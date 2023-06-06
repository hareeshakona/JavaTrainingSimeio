package com.doctorapp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.Queries;

@Repository
public class DoctorRepositoryImpl implements IDoctorRepository {	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addDoctor(Doctor doctor) {
		/*try {
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
		}*/

	}

	@Override
	public int updateDoctor(int doctorId, double fees) {
		int updated = 0;
		/*try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);
			statement.setDouble(1, fees);
			statement.setInt(2, doctorId);
			updated = statement.executeUpdate(); //returns 1 if the update is successful
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
		}*/
		return updated;
		
	}

	@Override
	public void deleteDoctor(int doctorId) {
		/*try {
			Connection connection = DbConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);
			statement.setInt(1, doctorId);
			statement.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection();
		}*/
	}
	
	@Override
	public Doctor findById(int doctorId) {	
		return jdbcTemplate.queryForObject(Queries.QUERYBYID, new DoctorMapper(), doctorId);		
	}

	@Override
	public List<Doctor> findAllDcotors() {
		return jdbcTemplate.query(Queries.QUERYALL, new DoctorMapper());

	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) {		
		return jdbcTemplate.query(Queries.QUERYBYSPECIALITY, new DoctorMapper(),speciality);
	}

	@Override
	public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
		return jdbcTemplate.query(Queries.QUERYBYSPECIALITYEXP, new DoctorMapper(),speciality,experience);
	}

	@Override
	public List<Doctor> findBySpecialityAndFees(String speciality, double fees) {
		return jdbcTemplate.query(Queries.QUERYBYSPECIALITYFEE, new DoctorMapper(),speciality,fees);
	}

	@Override
	public List<Doctor> findByAvailability(String speciality,LocalDateTime appointmentTime) {
		return jdbcTemplate.query(Queries.QUERYBYAVAILABILITY, new DoctorMapper(),speciality,appointmentTime);
	}
	
	

}
