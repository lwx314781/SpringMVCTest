package com.yongcheng.liuyang.model;

public class AccountInfo
{
	/**
	 * 主键id
	 */
	private int id;
	
	/**
	 * 用户账号Id
	 */
    private String userId;
    
    /**
     * 用户密码
     */
    private String password;
    
    private PatientInfo userInfo;
    
	public PatientInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(PatientInfo userInfo) {
		this.userInfo = userInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
