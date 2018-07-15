package com.yongcheng.liuyang.model;

import java.util.Date;

/**
 * 患者信息实体类
 * 
 * @author 刘洋
 *
 */
public class PatientInfo
{
    /**
     * 主键id
     */
    private String id;
    
    /**
     * 用户姓名
     */
    private String userName;
    
    /**
     * 电话
     */
    private String phoneNum;
    
    /**
     * 性别
     */
    private String sex;
    
    /**
     * 出生日期
     */
    private String bornTime;
    
    /**
     * 既往病史
     */
    private String medicalHistory;
    
    /**
     * 注册时间
     */
    private Date registeredTime;
    
    /**
     * 首次咨询时间
     */
    private Date firstConsult;
    
    /**
     * 头像
     */
    private String headPortrait;
    
    /**
     * 状态
     */
    private String status;
    
    /**
     * 备注
     */
    private String note;
    
    /**
     * 患者编号
     */
    private long patientNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBornTime() {
		return bornTime;
	}

	public void setBornTime(String bornTime) {
		this.bornTime = bornTime;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public Date getRegisteredTime() {
		return registeredTime;
	}

	public void setRegisteredTime(Date registeredTime) {
		this.registeredTime = registeredTime;
	}

	public Date getFirstConsult() {
		return firstConsult;
	}

	public void setFirstConsult(Date firstConsult) {
		this.firstConsult = firstConsult;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(long patientNo) {
		this.patientNo = patientNo;
	}

}


