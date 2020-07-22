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

package com.zhang.web.modules.sys.service.impl;


import com.zhang.web.modules.sys.entity.SysUser;
import com.zhang.web.modules.sys.mapper.SysUserMapper;
import com.zhang.web.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统用户
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl  implements SysUserService {
	@Autowired
    SysUserMapper sysUserMapper;

	@Override
	public SysUser loadUserRoleAndPermissionByUsername(String username) {
		return sysUserMapper.loadUserRoleAndPermissionByUsername(username);
	}

	@Override
	public SysUser loadUserByUsername(String username) {
		return sysUserMapper.loadUserByUsername(username);
	}

	@Override
	public void addUser(SysUser sysUser) {
		SysUser _sysUser=sysUserMapper.loadUserByUsername(sysUser.getUsername());
		if(_sysUser==null){
			sysUserMapper.addUser(sysUser);
		}else{
			sysUser.setUserId(_sysUser.getUserId());
			sysUserMapper.updateUserByUsername(sysUser);
		}
	}

	@Override
	public void loginUser(SysUser sysUser) {
		sysUserMapper.loginUser(sysUser);
	}

}
