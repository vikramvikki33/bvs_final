package com.sounds.bvs.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails extends PersonalAddressDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = -7422292757248795952L;

	@Id
	@Column(name="USER_ID", length=25, updatable=false)
	private String userId;

	@Column(name="USER_NAME", length=50)
	@NotBlank(message="Please enter a User Name")
	private String userName;

	@Column(name="EMAIL_ID", length=100)
	private String emailId;

	@Column(name="USER_STATUS")
	private boolean userStatus;

	@Column(name="USER_LEVEL", length=20)
	private String userLevel;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
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

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserDetails))
			return false;
		UserDetails other = (UserDetails) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


}
