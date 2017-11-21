package com.lys_ssh.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.lys_ssh.base.entity.IdEntity;

/**
 * 
 * @todo 用户User实体类
 * @author 刘云生
 * @datetime 2017年11月21日下午2:58:09
 * @email 578888218@qq.com
 */
@Entity
@Table(name = "tb_user")
public class UserEntity extends IdEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_name", length = 50, nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
