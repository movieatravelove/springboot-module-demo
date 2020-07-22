package com.zhang.web.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class QuestFilter {

	public static void main(String[] args) {
		try {
			String str=FileUtils.readFileToString(new File("E:/1.java"));
			System.out.println(filterPageBreak(str));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String filter(String str) {
		if (str == null) {
			return str;
		}
		String imageUrl = "http://dxhquestimgs.daoxuehao.com";
		str = str.replace("<p>&nbsp;</p>", "");
		str = str.replace("/quiz/images/", "quiz/images/");
		str = str.replace("quiz/images/", imageUrl + "/quiz/images/");
		str = str.replace("/STSource/", "STSource/");
		str = str.replace("STSource/", imageUrl + "/STSource/");
		str = str.replace("lftbbgxx/", imageUrl + "/lftbbgxx/");
		str = str.replace("lftbookCutImgs/", imageUrl + "/doakimages/");
		str = str.replace("doakimages/", imageUrl + "/doakimages/");
		str = str.replace("/questImg/", imageUrl + "/questImg/");
		str = str.replace("/Attachments/", "Attachments/");
		str = str.replace("Attachments/", imageUrl + "/Attachments/");
		return str;

	}
	/**
	 * 去除文科题目分割线下面的文字信息
	 * @param str
	 * @return
	 */
	public static String filterPageBreak(String str){
		StringBuffer sb=new StringBuffer();
		if(str!=null&&str.indexOf("page-break-after:always")>-1&&str.indexOf("display:none")>-1) {
			BufferedReader rd=new BufferedReader(new StringReader(str));
			String line=null;
			try {
				while((line=rd.readLine())!=null) {
					if(line.indexOf("page-break-after:always")>-1&&line.indexOf("display:none")>-1) {
						break;
					}
					sb.append(line).append("\r\n");
				}
				Document doc = Jsoup.parse(sb.toString());
				doc.getElementsByTag("img").addClass("quest-shot");
				return doc.body().html();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return str;
			}
		}else {
			return str;
		}
		
		 
	}
	public static String formartToWeb(String questContent) {

		Document doc = Jsoup.parse(questContent);
		Elements ps = doc.getElementsByTag("p");
		int length = 0;
		boolean hasGS = false;
		for (int i = 1; i < ps.size(); i++) {
			Element p = ps.get(i);
			String pcontent = p.text().trim();
			hasGS = pcontent.indexOf("$") > -1;
			if (pcontent.length() > 0) {
				Pattern pattern = Pattern.compile("^[A-F][.、．].*");
				// 忽略大小写的写法
				// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(pcontent);
				// 字符串是否与正则表达式相匹配
				boolean rs = matcher.matches();
				if (rs) {
					p.addClass("opt");
					length += p.text().length();
				}
			}
		}
		doc = Jsoup.parse(doc.outerHtml());
		System.out.println("选项长度:" + length);
		Elements opentios = doc.getElementsByClass("opt");
		if (opentios.size() <3) { //如果找到的选项小于3个，则可能不是选项，就不处理了
			return questContent;
		}
		return doc.body().html();
	}
}
