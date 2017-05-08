package com.sounds.bvs.data.entities;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotBlank;

public class PersonalAddressDetails extends EnterpriseBaseDomain {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ADDRESS" , nullable=true)
	private String address;

	@Column(name="CITY", length=50, nullable=true)
    private String city;

	@Column(name="COUNTRY", length=25, nullable=true)
    private String country;

	@Column(name="EMAIL", nullable=true)
	private String email;

	@Column(name="PIN", length=15, nullable=true)
    private String pin;

	@Column(name="PHONE", length=25, nullable=true)
    private String phone;

	@Column(name="MOBILE", length=50, nullable=true)
    private String mobile;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
