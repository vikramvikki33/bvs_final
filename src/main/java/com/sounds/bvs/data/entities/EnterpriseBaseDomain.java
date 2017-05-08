package com.sounds.bvs.data.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class EnterpriseBaseDomain implements Serializable, Cloneable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8692301082602070806L;

	@Column(name="CREATED_BY", length=30, updatable=false)
	private String createdBy;

	@Column(name="CREATED_ON", updatable=false)
	@Temporal(TemporalType.DATE)
	private Date createdOn;

	@Column(name="MODIFIED_BY", length=30)
	private String modifiedBy;

	@Column(name="MODIFIED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;

	@Column(name="STAGE", length=25)
	private String stage;

	@Column(name="STATUS", length=25)
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
