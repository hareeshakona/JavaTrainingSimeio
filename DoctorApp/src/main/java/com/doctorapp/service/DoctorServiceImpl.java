package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.doctorapp.dao.DoctorDaoImpl;
import com.doctorapp.dao.IDoctorDao;
import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public class DoctorServiceImpl implements IDoctorService {
	
	IDoctorDao doctorDao = new DoctorDaoImpl();

	@Override
	public void addDoctor(Doctor doctor) {
		doctorDao.addDoctor(doctor);
	}

	@Override
	public int updateDoctor(int doctorId, double fees) {
		return doctorDao.updateDoctor(doctorId, fees);
	}
	
	@Override
	public void deleteDoctor(int doctorId) {
		doctorDao.deleteDoctor(doctorId);
	}

	@Override
	public Doctor getById(int doctorId) {
		return doctorDao.findById(doctorId);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = doctorDao.findAllDcotors();
		return doctors.stream().sorted().collect(Collectors.toList());		
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
		List<Doctor> doctorsBySpeciality = doctorDao.findBySpeciality(speciality);
		if (doctorsBySpeciality.isEmpty()) throw new DoctorNotFoundException("No doctor found for speciality "+speciality);
		return doctorsBySpeciality.stream().sorted().collect(Collectors.toList());
		
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException {
		List<Doctor> doctorsBySpecialityExp = doctorDao.findBySpecialityAndExp(speciality, experience);
		if (doctorsBySpecialityExp.isEmpty()) throw new DoctorNotFoundException("No doctor found for speciality "+speciality+" with minimum experience "+experience);
		return doctorsBySpecialityExp.stream().sorted().collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException {
		List<Doctor> doctorsBySpecialityFee = doctorDao.findBySpecialityAndFees(speciality, fees);
		if (doctorsBySpecialityFee.isEmpty()) throw new DoctorNotFoundException("No doctor found for speciality "+speciality+" with maximum fees "+fees);
		return doctorsBySpecialityFee.stream().sorted().collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getByAvailability(String speciality, LocalDateTime appointmentTime) throws DoctorNotFoundException{
		List<Doctor> doctorsByAvailability = doctorDao.findByAvailability(speciality, appointmentTime);
		if (doctorsByAvailability.isEmpty()) throw new DoctorNotFoundException("No doctor found for speciality "+speciality+" available around "+appointmentTime);
		return doctorsByAvailability.stream().sorted().collect(Collectors.toList());
	}

}
