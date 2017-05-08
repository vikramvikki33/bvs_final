package com.sounds.bvs.data.vo;

public class UserDetailsVo extends EnterpriseVo {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String userId;

	private String userName;

	private String emailId;

	private boolean userStatus;

	private String userLevel;

	/**
	 * @return the userId
	 */
	public final String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public final void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public final String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public final void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the emailId
	 */
	public final String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public final void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	/**
	 * @return the userStatus
	 */
	public final boolean isUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public final void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the userLevel
	 */
	public final String getUserLevel() {
		return userLevel;
	}

	/**
	 * @param userLevel the userLevel to set
	 */
	public final void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

}
