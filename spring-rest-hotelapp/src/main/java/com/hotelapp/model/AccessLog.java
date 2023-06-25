package com.hotelapp.model;

import java.time.LocalDateTime;

public class AccessLog {

	private Integer logId;
	private String userName;
	private String activity;
	private LocalDateTime attemptedAt;
	private String status;
	private int numberOfAttempts;

	public AccessLog() {
		super();
	}

	public AccessLog(Integer logId, String userName, String activity, LocalDateTime attemptedAt, String status,
			int numberOfAttempts) {
		super();
		this.logId = logId;
		this.userName = userName;
		this.activity = activity;
		this.attemptedAt = attemptedAt;
		this.status = status;
		this.numberOfAttempts = numberOfAttempts;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public LocalDateTime getAttemptedAt() {
		return attemptedAt;
	}

	public void setAttemptedAt(LocalDateTime attemptedAt) {
		this.attemptedAt = attemptedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumberOfAttempts() {
		return numberOfAttempts;
	}

	public void setNumberOfAttempts(int numberOfAttempts) {
		this.numberOfAttempts = numberOfAttempts;
	}

	@Override
	public String toString() {
		return "AccessLog [logId=" + logId + ", userName=" + userName + ", activity=" + activity + ", attemptedAt="
				+ attemptedAt + ", status=" + status + ", numberOfAttempts=" + numberOfAttempts + "]";
	}

}
