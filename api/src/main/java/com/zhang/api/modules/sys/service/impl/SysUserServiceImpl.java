/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.zhang.api.modules.sys.service.impl;



import com.baomidou.mybatisplus.plugins.Page;
import com.zhang.api.modules.sys.entity.SysUser;
import com.zhang.api.modules.sys.mapper.SysUserMapper;
import com.zhang.api.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl  implements SysUserService {
	@Autowired
    SysUserMapper sysUserMapper;

	@Override
	public SysUser loadUserByUsername(String username) {
		return sysUserMapper.loadUserByUsername(username);
	}

	@Override
	public Page listUsersPage(Integer currentPage, Integer pageSize) {
		Page<SysUser> page = new Page<SysUser>(currentPage,pageSize);
		Map<String, Object> params=new HashMap<>();
		List<SysUser> homeworkList=sysUserMapper.listUsersPage(page,params);
		page.setRecords(homeworkList);
		return page;
	}
}
