package com.sounds.bvs.data.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SUB_CLIENTS")
public class SubClients extends PersonalAddressDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SUB_CLIENT_ID", length=5)
	private int subClientId;

	@ManyToOne
	@JoinColumn(name="CLIENT_ID", nullable=false, updatable=false)
	private Clients clients;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="subClients")
	private List<Profiles> profiles = new ArrayList<>();

	@Column(name="BUSINESS_TYPE", length=100)
    private String businessType;

	@Column(name="CONTACT_PERSON_NAME", length=50, nullable=true)
    private String contactPersonName;

	@Column(name="CONATACT_REFERENCE", length=50, nullable=true)
    private String contactReference;

	@Column(name="SECONDARY_EMAILS", nullable=true)
    private String secondaryEmails;

	@Column(name="HOLIDAY_TYPE", length=5, nullable=true)
    private String holidayType;

	@Column(name="HOLIDAY_TEMPLATE", length=25, nullable=true)
    private String holidayTemplate;

	@Column(name="WEEKLY_OFF_TEMPLATE", length=25, nullable=true)
    private String weeklyOffTemplate;

	@Column(name="INSUFF_EMAIL", nullable=true)
    private String insuffEmail;

	@Column(name="DISCREPANCY_EMAIL", nullable=true)
    private String discrepancyEmail;

	@Column(name="TAT_CALCULATION_DAY", length=5, nullable=true)
    private String tatCalculationDay;

	@Column(name="EFFECTIVE_DATE", nullable=true)
	@Temporal(TemporalType.DATE)
    private Date effectiveDate;

	@Column(name="DESCRIPTION", length=25, nullable=true)
    private String description;

	@Column(name="TAT_FOR", length=5, nullable=true)
    private String tatFor;

	@Column(name="TAT_PER_CASE", nullable=true)
	private int tatPerCase;

	@Column(name="INDUSTRY_ID", length=20, nullable=true)
    private String industryId;


	public int getSubClientId() {
		return subClientId;
	}

	public void setSubClientId(int subClientId) {
		this.subClientId = subClientId;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}


	public String getContactReference() {
		return contactReference;
	}

	public void setContactReference(String contactReference) {
		this.contactReference = contactReference;
	}

	public String getSecondaryEmails() {
		return secondaryEmails;
	}

	public void setSecondaryEmails(String secondaryEmails) {
		this.secondaryEmails = secondaryEmails;
	}

	public String getHolidayType() {
		return holidayType;
	}

	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}

	public String getHolidayTemplate() {
		return holidayTemplate;
	}

	public void setHolidayTemplate(String holidayTemplate) {
		this.holidayTemplate = holidayTemplate;
	}

	public String getWeeklyOffTemplate() {
		return weeklyOffTemplate;
	}

	public void setWeeklyOffTemplate(String weeklyOffTemplate) {
		this.weeklyOffTemplate = weeklyOffTemplate;
	}

	public String getInsuffEmail() {
		return insuffEmail;
	}

	public void setInsuffEmail(String insuffEmail) {
		this.insuffEmail = insuffEmail;
	}

	public String getDiscrepancyEmail() {
		return discrepancyEmail;
	}

	public void setDiscrepancyEmail(String discrepancyEmail) {
		this.discrepancyEmail = discrepancyEmail;
	}

	public String getTatCalculationDay() {
		return tatCalculationDay;
	}

	public void setTatCalculationDay(String tatCalculationDay) {
		this.tatCalculationDay = tatCalculationDay;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTatFor() {
		return tatFor;
	}

	public void setTatFor(String tatFor) {
		this.tatFor = tatFor;
	}

	public int getTatPerCase() {
		return tatPerCase;
	}

	public void setTatPerCase(int tatPerCase) {
		this.tatPerCase = tatPerCase;
	}

	public String getIndustryId() {
		return industryId;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	public List<Profiles> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profiles> profiles) {
		this.profiles = profiles;
	}
}
