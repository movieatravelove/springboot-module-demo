package com.zhang.web.utils.quest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.zhang.web.utils.AESUtil;
import com.zhang.web.utils.HttpClientUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DxhQuest {
	
	/**
	 * sid取题
	 * 参数need:
	 * 第一位:question
	 * 第二位:answer
	 * 第三位:hint
	 * 第四位:think、qtdicFormular、qtdicPoint
	 * 第五位:diff
	 * 第六位:type
	 * 第七位:knowledges和video两个字段
	 * 第八位:practice
	 * 第九位:modifyanswer(不管是0,1,或者是没有值 全都返true)
	 * 第十位:multimedia
	 * @param sid
	 * @param need
	 * @return
	 */
	public static JSONObject getSource(String QuestEngineServer, String sid,String need){
		JSONObject root=null;
		try {
			// 根据SID获取题目和答案信息
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("sid",sid));
			nvps.add(new BasicNameValuePair("need",need));
			JSONObject questResult=JSONObject.fromObject(HttpClientUtil.post(QuestEngineServer+"sid/getQuest",nvps));
			if(questResult!=null && questResult.getInt("code")==200){
				root = questResult.getJSONObject("result").getJSONObject("source");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return root;
	}
	
	
	/**
	 * 获取导学号辅导信息
	 * @param dxh
	 * @param need 
	 * 		第一位对应 question(题目)
			第二位对应 answer(答案)
			第三位对应 全部信息
	 * @return
	 */
	public static JSONObject getDxhCoaching(String getQuestByDxhUrl,String dxh,String need){
		JSONObject questObj=null;
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("dxh",dxh));
			nvps.add(new BasicNameValuePair("need",need));
			JSONObject result = JSONObject.fromObject(HttpClientUtil.post(getQuestByDxhUrl,nvps));
			if(result.getInt("code")==200){
				questObj=result.getJSONObject("result");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questObj;
	}
	
	/**
	 * 辅导页面题目总结
	 * @return
	 */
	public static JSONObject questSummary(String similarQuestRecommendAnswerUrl,String dxh,int num){
		JSONObject questSummary=null;
		try {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("dxh",dxh));
			nvps.add(new BasicNameValuePair("num",String.valueOf(num)));
			JSONObject similarQuest = JSONObject.fromObject(HttpClientUtil.post(similarQuestRecommendAnswerUrl,nvps));
			if(similarQuest.getInt("code")==200){
				questSummary=new JSONObject();
				JSONObject similarQuestResult=similarQuest.getJSONObject("result");
				if(!similarQuestResult.isNullObject() && !similarQuestResult.isEmpty()){
					JSONArray similarQuestArray=similarQuestResult.getJSONArray("list");
					int similarQuestCount=similarQuestResult.getInt("similarQuestCount");
					int resultQuestCount=similarQuestResult.getInt("resultQuestCount");
					for (int i = 0; i < similarQuestArray.size(); i++) {
						JSONObject tixing = similarQuestArray.getJSONObject(i).getJSONObject("questCoaching");
						String tixingUrl =  tixing.getString("knowcase");
						String dx = tixingUrl.substring(tixingUrl.indexOf("dxh=")+4);
						tixingUrl = tixingUrl.replace(dx, AESUtil.encrypt(dx)).replace("detail", "detail-dcg");
						tixing.put("knowcase", tixingUrl);
					}
					questSummary.put("title", "形似题雷达·举一反三");
					questSummary.put("subtitle", "导学号探测到"+similarQuestCount+"道形似题，总结出了"+resultQuestCount+"种题型变化");
					questSummary.put("list", similarQuestArray);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questSummary;
	}	
	
	/**
	 * 判断导学号是否是书籍（一号一书）
	 * @return
	 */
	public static boolean dxhIsBook(String dxh){
		// 匹配模式,\\d代表匹配数字,{7}代表正好匹配次数
        String regex = "\\d{7}";
        return Pattern.matches(regex, dxh);
	}
}
