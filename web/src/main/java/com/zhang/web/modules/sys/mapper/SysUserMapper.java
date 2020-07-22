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

package com.zhang.web.modules.sys.mapper;


import com.zhang.web.datasources.DataSourceNames;
import com.zhang.web.datasources.annotation.DataSource;
import com.zhang.web.modules.sys.entity.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper{

	@DataSource(name = DataSourceNames.FIRST)
    SysUser loadUserRoleAndPermissionByUsername(String username);

    @DataSource(name = DataSourceNames.FIRST)
    void addUser(SysUser sysUser);

    @DataSource(name = DataSourceNames.FIRST)
    void loginUser(SysUser sysUser);
    @DataSource(name = DataSourceNames.FIRST)
    SysUser loadUserByUsername(String username);

    void updateUserByUsername(SysUser sysUser);
}
