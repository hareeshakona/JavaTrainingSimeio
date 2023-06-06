package com.doctorapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.DbConnection;
import com.doctorapp.util.Queries;

public class DoctorDaoImpl implements IDoctorDao {	

	@Override
	public void addDoctor(Doctor doctor) {
		try {
			//get the connection
			Connection connection = DbConnection.openConnection();
			//create prepared statement
			PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);
			//assign value for each column
			statement.setInt(1,doctor.getDoctorId());
			statement.setString(2, doctor.getDoctorName());
			statement.setString(3, doctor.getSpeciality());
			statement.setInt(4, doctor.getExperience());
			statement.setDouble(5, doctor.getFees());
			statement.setTimestamp(6, Timestamp.valueOf(doctor.getStartTime()));
			statement.setTimestamp(7, Timestamp.valueOf(doctor.getEndTime()));
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
		}

	}

	@Override
	public int updateDoctor(int doctorId, double fees) {
		int updated = 0;
		try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);
			statement.setDouble(1, fees);
			statement.setInt(2, doctorId);
			updated = statement.executeUpdate(); //returns 1 if the update is successful
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
		}
		return updated;
		
	}

	@Override
	public void deleteDoctor(int doctorId) {
		try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);
			statement.setInt(1, doctorId);
			statement.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
		}
	}
	
	@Override
	public Doctor findById(int doctorId) {	
		try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYID);
			statement.setInt(1, doctorId);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctorId"));
				doctor.setDoctorName(rs.getString("doctorName"));
				doctor.setSpeciality(rs.getString("speciality"));
				doctor.setExperience(rs.getInt("experience"));
				doctor.setFees(rs.getDouble("fees"));
				doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				return doctor;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
		}
		return null;
	}

	@Override
	public List<Doctor> findAllDcotors() {
		List<Doctor> doctors = new ArrayList<>();
		try {
			Connection connection = DbConnection.openConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(Queries.QUERYALL);
			while(rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctorId"));
				doctor.setDoctorName(rs.getString("doctorName"));
				doctor.setSpeciality(rs.getString("speciality"));
				doctor.setExperience(rs.getInt("experience"));
				doctor.setFees(rs.getDouble("fees"));
				doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				doctors.add(doctor);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
		}
		return doctors;

	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) {
		List<Doctor> doctorsBySpeciality = new ArrayList<>();
		try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYSPECIALITY);
			statement.setString(1, speciality);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctorId"));
				doctor.setDoctorName(rs.getString("doctorName"));
				doctor.setSpeciality(rs.getString("speciality"));
				doctor.setExperience(rs.getInt("experience"));
				doctor.setFees(rs.getDouble("fees"));
				doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				doctorsBySpeciality.add(doctor);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
		}
		return doctorsBySpeciality;
	}

	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
		List<Doctor> doctorsBySpecialityExp = new ArrayList<>();
		try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYSPECIALITYEXP);
			statement.setString(1, speciality);
			statement.setInt(2, experience);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctorId"));
				doctor.setDoctorName(rs.getString("doctorName"));
				doctor.setSpeciality(rs.getString("speciality"));
				doctor.setExperience(rs.getInt("experience"));
				doctor.setFees(rs.getDouble("fees"));
				doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				doctorsBySpecialityExp.add(doctor);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
		}
		return doctorsBySpecialityExp;
	}

	@Override
	public List<Doctor> findBySpecialityAndFees(String speciality, double fees) {
		List<Doctor> doctorsBySpecialityFee = new ArrayList<>();
		try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYSPECIALITYFEE);
			statement.setString(1, speciality);
			statement.setDouble(2, fees);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctorId"));
				doctor.setDoctorName(rs.getString("doctorName"));
				doctor.setSpeciality(rs.getString("speciality"));
				doctor.setExperience(rs.getInt("experience"));
				doctor.setFees(rs.getDouble("fees"));
				doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				doctorsBySpecialityFee.add(doctor);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
		}
		return doctorsBySpecialityFee;
	}

	@Override
	public List<Doctor> findByAvailability(String speciality,LocalDateTime appointmentTime) {
		List<Doctor> doctorsByAvailability = new ArrayList<>();
		try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYAVAILABILITY);
			statement.setString(1, speciality);
			statement.setTimestamp(2, Timestamp.valueOf(appointmentTime));
			statement.setTimestamp(3, Timestamp.valueOf(appointmentTime));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctorId(rs.getInt("doctorId"));
				doctor.setDoctorName(rs.getString("doctorName"));
				doctor.setSpeciality(rs.getString("speciality"));
				doctor.setExperience(rs.getInt("experience"));
				doctor.setFees(rs.getDouble("fees"));
				doctor.setStartTime(rs.getTimestamp("startTime").toLocalDateTime());
				doctor.setEndTime(rs.getTimestamp("endTime").toLocalDateTime());
				doctorsByAvailability.add(doctor);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbConnection.closeConnection();
		}
		return doctorsByAvailability;
	}
	
	

}
