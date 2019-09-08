package com.trantrongnhan.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="user")
public class UserEntity extends AbstractEntity{
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="roleid")
	private Integer roleId;
	@ManyToMany
	@JoinTable(name="user_role",joinColumns= {@JoinColumn(name="userid")},inverseJoinColumns= {@JoinColumn(name="roleid")})
	private Set<RoleEntity> roleEntitys=new HashSet<>();

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Set<RoleEntity> getRoleEntitys() {
		return roleEntitys;
	}

	public void setRoleEntitys(Set<RoleEntity> roleEntitys) {
		this.roleEntitys = roleEntitys;
	}
	
}
