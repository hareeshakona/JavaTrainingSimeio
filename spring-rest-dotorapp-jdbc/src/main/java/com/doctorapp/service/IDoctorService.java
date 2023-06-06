package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService {

	void addDoctor(Doctor doctor);

	int updateDoctor(int doctorId, double fees);
	
	void deleteDoctor(int doctorId);

	Doctor getById(int doctorId);

	List<Doctor> getAllDoctors();

	List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException;

	List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException;

	List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException;
	
	List<Doctor> getByAvailability(String speciality, LocalDateTime appointmentTime) throws DoctorNotFoundException;

}
