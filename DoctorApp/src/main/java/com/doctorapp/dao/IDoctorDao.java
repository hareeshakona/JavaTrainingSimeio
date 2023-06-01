package com.doctorapp.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorDao {

	void addDoctor(Doctor doctor);

	int updateDoctor(int doctorId, double fees);

	void deleteDoctor(int doctorId);
	
	Doctor findById(int doctorId);

	List<Doctor> findAllDcotors();

	List<Doctor> findBySpeciality(String speciality);

	List<Doctor> findBySpecialityAndExp(String speciality, int experience);

	List<Doctor> findBySpecialityAndFees(String speciality, double fees);

	List<Doctor> findByAvailability(String speciality, LocalDateTime appointmentTime);

}
