package com.zhang.web.modules.sys.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * 类名称：角色
 *
 */
@Data
public class Role implements Serializable{
	private int id;
	private String name;
	private String perms;
	private String note;
}
