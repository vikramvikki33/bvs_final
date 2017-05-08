package com.sounds.bvs.data.vo;

import java.io.Serializable;
import java.util.Date;

public class EnterpriseVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3115641878854823837L;

	private String createdBy;

	private Date createdOn;

	private String modifiedBy;

	private Date modifiedOn;

	private String stage;

	private String status;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(final Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(final String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(final Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public final String getStage() {
		return stage;
	}

	public final void setStage(final String stage) {
		this.stage = stage;
	}

	public final String getStatus() {
		return status;
	}

	public final void setStatus(final String status) {
		this.status = status;
	}

}
