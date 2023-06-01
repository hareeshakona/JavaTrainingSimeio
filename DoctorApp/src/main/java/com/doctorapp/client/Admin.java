package com.doctorapp.client;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;

public class Admin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IDoctorService iDoctorService = new DoctorServiceImpl();
		
		System.out.println("Please select an option \n "
				+ "1 - ADD DOCTOR \n 2 - UPDATE DOCTOR \n 3 - DELETE DOCTOR \n 4 - GET DOCTOR BY ID \n"
				+ " 5 - GET ALL DOCTORS \n 6 - GET DOCTOR BY SPECIALITY \n 7 - GET DOCTOR BY SPECIALITY & EXPERIENCE \n "
				+ "8 - GET DOCTOR BY SPECIALITY & FEES \n 9 - GET DOCTOR BY SPECIALITY & AVAILABILITY");
		
		int option = sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		case 1 : { 
			System.out.println("Enter Doctor details");
			System.out.println("Enter id");
			int doctorId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter name");
			String doctorName = sc.nextLine();
			System.out.println("Enter speciality");
			String speciality = sc.nextLine();
			System.out.println("Enter experience");
			int experience = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter fees");
			double fees = sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter start time in format YYYY-MM-DDThh:mm:ss");
			String startTime = sc.nextLine();
			System.out.println("Enter end time in format YYYY-MM-DDThh:mm:ss");
			String endTime = sc.nextLine();
			
			Doctor doctor = new Doctor();
			doctor.setDoctorId(doctorId);
			doctor.setDoctorName(doctorName);
			doctor.setSpeciality(speciality);
			doctor.setExperience(experience);
			doctor.setFees(fees);
			doctor.setStartTime(LocalDateTime.parse(startTime));
			doctor.setEndTime(LocalDateTime.parse(endTime));
			
			iDoctorService.addDoctor(doctor);
			System.out.println("Doctor added");
			break;
		}
		case 2 : {
			System.out.println("Enter Doctor Id");
			int doctorId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter fees");
			double fees = sc.nextDouble();
			sc.nextLine();
			
			iDoctorService.updateDoctor(doctorId, fees);
			System.out.println("Doctor updated");
			break;
		}
		case 3 : {
			System.out.println("Enter Doctor Id");
			int doctorId = sc.nextInt();
			sc.nextLine();
			
			iDoctorService.deleteDoctor(doctorId);
			System.out.println("Doctor deleted");
			break;
		}
		case 4 : {
			System.out.println("Enter Doctor Id");
			int doctorId = sc.nextInt();
			sc.nextLine();
			
			Doctor doctor = iDoctorService.getById(doctorId);
			System.out.println(doctor);			
			break;
		}
		case 5 : {
			List<Doctor> doctors = iDoctorService.getAllDoctors();
			doctors.stream().map(doctor -> doctor.getDoctorName()).forEach(System.out::println);
			break;
		}
		case 6 : {
			System.out.println("Enter speciality");
			String speciality = sc.nextLine();
			
			try {
				List<Doctor> doctorsBySpeciality = iDoctorService.getBySpeciality(speciality);
				doctorsBySpeciality.stream().forEach(System.out::println);
			} catch (DoctorNotFoundException e) {
				e.printStackTrace();
			}
			break;			
		}
		case 7 : {
			System.out.println("Enter speciality");
			String speciality = sc.nextLine();
			System.out.println("Enter experience");
			int experience = sc.nextInt();
			sc.nextLine();
			
			try {
				List<Doctor> doctorsBySpecialityExp = iDoctorService.getBySpecialityAndExp(speciality, experience);
				doctorsBySpecialityExp.stream().forEach(System.out::println);
			} catch (DoctorNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		case 8 : {
			System.out.println("Enter speciality");
			String speciality = sc.nextLine();
			System.out.println("Enter fees");
			double fees = sc.nextDouble();
			sc.nextLine();
			
			try {
				List<Doctor> doctorsBySpecialityFee = iDoctorService.getBySpecialityAndFees(speciality, fees);
				doctorsBySpecialityFee.stream().forEach(System.out::println);
			} catch (DoctorNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		case 9 : {
			System.out.println("Enter speciality");
			String speciality = sc.nextLine();
			System.out.println("Enter availability in format YYYY-MM-DDThh:mm:ss");
			String availability = sc.nextLine();
			
			try {
				List<Doctor> doctorsByAvailability = iDoctorService.getByAvailability(speciality, LocalDateTime.parse(availability));
				doctorsByAvailability.stream().forEach(System.out::println);
			} catch (DoctorNotFoundException e) {
				e.printStackTrace();
			}			
		}
		}
		sc.close();

	}

}
