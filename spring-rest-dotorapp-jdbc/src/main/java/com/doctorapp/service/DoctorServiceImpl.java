package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {
	
	IDoctorRepository doctorRepository;

	public DoctorServiceImpl(IDoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		doctorRepository.addDoctor(doctor);
	}

	@Override
	public int updateDoctor(int doctorId, double fees) {
		return doctorRepository.updateDoctor(doctorId, fees);
	}
	
	@Override
	public void deleteDoctor(int doctorId) {
		doctorRepository.deleteDoctor(doctorId);
	}

	@Override
	public Doctor getById(int doctorId) {
		Optional<Doctor> doctor =  Optional.of(doctorRepository.findById(doctorId));
		return doctor.orElseThrow(()-> new DoctorNotFoundException());
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = doctorRepository.findAllDcotors();
		return doctors.stream().sorted(Comparator.comparing(Doctor::getDoctorName)).collect(Collectors.toList());		
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		List<Doctor> doctorsBySpeciality = doctorRepository.findBySpeciality(speciality);
		if (doctorsBySpeciality.isEmpty()) throw new DoctorNotFoundException("No doctor found for speciality "+speciality);
		return doctorsBySpeciality.stream().sorted(Comparator.comparing(Doctor::getDoctorName)).collect(Collectors.toList());
		
	}

	@Override
	public List<Doctor> getBySpecialityAndExp(String speciality, int experience) {
		List<Doctor> doctorsBySpecialityExp = doctorRepository.findBySpecialityAndExp(speciality, experience);
		if (doctorsBySpecialityExp.isEmpty()) throw new DoctorNotFoundException("No doctor found for speciality "+speciality+" with minimum experience "+experience);
		return doctorsBySpecialityExp.stream().sorted(Comparator.comparing(Doctor::getExperience).reversed()).collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) {
		List<Doctor> doctorsBySpecialityFee = doctorRepository.findBySpecialityAndFees(speciality, fees);
		if (doctorsBySpecialityFee.isEmpty()) throw new DoctorNotFoundException("No doctor found for speciality "+speciality+" with maximum fees "+fees);
		return doctorsBySpecialityFee.stream().sorted(Comparator.comparing(Doctor::getFees)).collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getByAvailability(String speciality, LocalDateTime appointmentTime) {
		List<Doctor> doctorsByAvailability = doctorRepository.findByAvailability(speciality, appointmentTime);
		if (doctorsByAvailability.isEmpty()) throw new DoctorNotFoundException("No doctor found for speciality "+speciality+" available around "+appointmentTime);
		return doctorsByAvailability.stream().sorted(Comparator.comparing(Doctor::getDoctorName)).collect(Collectors.toList());
	}

}
