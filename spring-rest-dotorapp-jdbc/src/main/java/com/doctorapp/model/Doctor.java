package com.doctorapp.model;

import java.time.LocalDateTime;

public class Doctor {

	private Integer doctorId;
	private String doctorName;
	private String speciality;
	private double fees;
	private int experience;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	public Doctor() {
		super();
	}

	public Doctor(Integer doctorId, String doctorName, String speciality, double fees, int experience,
			LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;	
		this.speciality = speciality;
		this.fees = fees;
		this.experience = experience;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", speciality=" + speciality + ", fees="
				+ fees + ", experience=" + experience + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}
