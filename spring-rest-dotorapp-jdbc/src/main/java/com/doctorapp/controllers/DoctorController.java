package com.doctorapp.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@RestController
@RequestMapping("/doctor-api")
public class DoctorController {
	
	IDoctorService doctorService;

	public DoctorController(IDoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	void addDoctor(Doctor doctor) {
	}

	int updateDoctor(int doctorId, double fees) {
		return 0;
	}
	
	void deleteDoctor(int doctorId) {
		
	}

	Doctor getById(int doctorId) {
		return null;
		
	}

	@GetMapping("/doctors")
	List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
		
	}

	@GetMapping("/doctors/speciality")
	List<Doctor> getBySpeciality(@RequestParam("speciality") String speciality) {
		return doctorService.getBySpeciality(speciality);
		
	}

	@GetMapping("/doctors/speciality-exp")
	List<Doctor> getBySpecialityAndExp(@RequestParam("speciality") String speciality,@RequestParam("experience") int experience) {
		return doctorService.getBySpecialityAndExp(speciality, experience);
		
	}
	
	@GetMapping("/doctors/speciality-fees")
	List<Doctor> getBySpecialityAndFees(@RequestParam("speciality") String speciality,@RequestParam("fees") double fees) {
		return doctorService.getBySpecialityAndFees(speciality, fees);
		
	}
	
	@GetMapping("/doctors/speciality-availability")
	List<Doctor> getByAvailability(@RequestParam("speciality") String speciality,@RequestParam("time") String appointmentTime) {
		return doctorService.getByAvailability(speciality, LocalDateTime.parse(appointmentTime));
		
	}

}
