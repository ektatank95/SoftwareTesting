package com.company.varnaa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;


@Entity
//@Table(name="appointment",schema = "hospital")
@DynamicUpdate
public class appointment {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="appointmentId")
	private Integer appointmentId;
	
	@Column(name="patientName")
	private String patientName;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="appointment_date")
	private String date;

	@Column(name="prescription")
	private String prescription;
	
	@Column(name="confirmed")
	private String confirmed;
	
	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}


	@Override
	public String toString() {
		return "appointment [appointmentId=" + appointmentId + ", patientName=" + patientName + ", doctorName="
				+ doctorName + ", date=" + date + ", prescription=" + prescription + "]";
	}

	public appointment(String patientName, String doctorName, String date,
			String prescription,String confirmed) {
		super();
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.date = date;
		this.prescription = prescription;
		this.confirmed=confirmed;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public appointment() {}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
}
