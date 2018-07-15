package com.yongcheng.liuyang.model;

import java.util.Date;

/**
 * 系统当前管理人员信息
 * 
 * @author liuyang
 * @since 2018-07-15
 */
public class ManagerInfo 
{
    /**
     * 主键id	
     */
	private int id;
	
    /**
     * 用户电话
     */
    private String phoneNum;
    
    /**
     * 用户真实姓名
     */
    private String userName;
    
    /**
     * 是否在线
     */
    private String isOnline;
    
    /**
     * 用户状态（是否为会员）
     */
    private String userStatus;
    
    /**
     * 用户类型（患者、医生、管理人员）
     */
    private String userType;
    
    /**
     * 当前角色（针对管理人员）
     */
    private String roles;
    
    /**
     * 创建人
     */
    private String creator;
    
    /**
     * 创建部门
     */
    private String creatorDep;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 修改人
     */
    private String modifior;
    
    /**
     * 修改部门
     */
    private String modifiDep;
    
    /**
     * 修改时间
     */
    private Date modifyTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatorDep() {
		return creatorDep;
	}

	public void setCreatorDep(String creatorDep) {
		this.creatorDep = creatorDep;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifior() {
		return modifior;
	}

	public void setModifior(String modifior) {
		this.modifior = modifior;
	}

	public String getModifiDep() {
		return modifiDep;
	}

	public void setModifiDep(String modifiDep) {
		this.modifiDep = modifiDep;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
    
}
