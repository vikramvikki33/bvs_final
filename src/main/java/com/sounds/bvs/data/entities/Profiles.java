package com.sounds.bvs.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROFILES")
public class Profiles extends PersonalAddressDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROFILE_ID", length=5)
	private int profileId;

	@ManyToOne
	@JoinColumn(name="CLIENT_ID", nullable=false, updatable=false)
	private Clients clients;

	@ManyToOne
	@JoinColumn(name="SUB_CLIENT_ID", nullable=false, updatable=false)
	private SubClients subClients;


	@Column(name="PROFILE_NAME", length=50)
    private String profileName;

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public SubClients getSubClients() {
		return subClients;
	}

	public void setSubClients(SubClients subClients) {
		this.subClients = subClients;
	}
}
