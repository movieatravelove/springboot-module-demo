package com.zhang.web.modules.sys.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String username;
	private String password;
	private String realName;
	private int roleId;
	private String lastLoginDate;
	private String lastLoginIp;
	private int status;
	private String email;
	private String phone;
	private String registDate;
	private Role role;			//角色对象
	private String source;
	private int schoolId;
	public String getCredentialsSalt() {
		return username;
	}
}