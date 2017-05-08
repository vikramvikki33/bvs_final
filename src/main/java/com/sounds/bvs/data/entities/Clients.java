package com.sounds.bvs.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@NamedQueries ({
	@NamedQuery(name=Clients.FIND_ALL_CLIENTS_QUERY_NAME , query="SELECT c FROM Clients c"),
})

@Entity
@Table(name="CLIENTS")
public class Clients extends PersonalAddressDetails {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL_CLIENTS_QUERY_NAME = "FIND_ALL_CLIENTS";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLIENT_ID", length=5)
	private int clientId;

	@NotBlank(message="Client Name can't be Blank")
	@Size(min=3, max=50, message="Client Name should be greater then 3 Characters Or Less Then 50 Characters")
	@Column(name="CLIENT_NAME", length=50 , nullable=true)
	private String clientName;

	@Column(name="CONTACT_PERSON_NAME", length=50, nullable=true)
	private String contactPersonName;

	@Column(name="CONTACT_REFERENCE", length=50,  nullable=true)
    private String contactReference;


	@Column(name="DE_SUBJECT", nullable=true)
    private String deSubject;

	@Column(name="DE_BODY", nullable=true)
    private String deBody;

	@Column(name="DE_THANK_YOU", nullable=true)
    private String deThankYou;

	@Column(name="DE_REJECT", nullable=true)
    private String deReject;

	@Column(name="DE_ACCEPT", nullable=true)
    private String deAccept;

	@Column(name="DE_REJECT_SUBJECT", nullable=true)
    private String deRejectSubject;

	@Column(name="DE_ACCEPT_SUBJECT", nullable=true)
    private String deAcceptSubject;

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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

	public String getDeSubject() {
		return deSubject;
	}

	public void setDeSubject(String deSubject) {
		this.deSubject = deSubject;
	}

	public String getDeBody() {
		return deBody;
	}

	public void setDeBody(String deBody) {
		this.deBody = deBody;
	}

	public String getDeThankYou() {
		return deThankYou;
	}

	public void setDeThankYou(String deThankYou) {
		this.deThankYou = deThankYou;
	}

	public String getDeReject() {
		return deReject;
	}

	public void setDeReject(String deReject) {
		this.deReject = deReject;
	}

	public String getDeAccept() {
		return deAccept;
	}

	public void setDeAccept(String deAccept) {
		this.deAccept = deAccept;
	}

	public String getDeRejectSubject() {
		return deRejectSubject;
	}

	public void setDeRejectSubject(String deRejectSubject) {
		this.deRejectSubject = deRejectSubject;
	}

	public String getDeAcceptSubject() {
		return deAcceptSubject;
	}

	public void setDeAcceptSubject(String deAcceptSubject) {
		this.deAcceptSubject = deAcceptSubject;
	}

}
