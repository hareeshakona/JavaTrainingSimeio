package com.hotelapp.repository;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.AccessLog;
import com.hotelapp.util.Queries;

@Repository
public class AccessLogRepositoryImpl implements IAccessLogRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void logActivity(AccessLog accessLog) {
		Object[] logArray = { accessLog.getUserName(), accessLog.getActivity(),
				Timestamp.valueOf(accessLog.getAttemptedAt()), accessLog.getStatus(), accessLog.getNumberOfAttempts() };
		jdbcTemplate.update(Queries.ACCESSLOGINSERTQUERY, logArray);
	}

}
