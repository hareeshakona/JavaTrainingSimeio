package com.hotelapp.repository;

import com.hotelapp.model.AccessLog;

public interface IAccessLogRepository {

	void logActivity(AccessLog accessLog);
}
