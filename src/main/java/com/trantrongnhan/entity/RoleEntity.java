package com.trantrongnhan.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleEntity extends AbstractEntity{
	@Column(name="name")
	private String name;
	@Column(name="code")
	private String code;
	@ManyToMany(mappedBy="roleEntitys")
	private Set<UserEntity>userEntitys=new HashSet<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Set<UserEntity> getUserEntitys() {
		return userEntitys;
	}
	public void setUserEntitys(Set<UserEntity> userEntitys) {
		this.userEntitys = userEntitys;
	}
}
