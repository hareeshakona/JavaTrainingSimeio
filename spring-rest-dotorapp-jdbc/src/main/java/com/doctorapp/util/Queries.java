package com.doctorapp.util;

public class Queries {

	public static final String CREATEQUERY = "create table doctor (doctorId number primary key, doctorName varchar(20), speciality varchar(30), experience number, fees real, startTime timestamp, endTime timestamp)";

	public static final String INSERTQUERY = "insert into doctor(doctorId, doctorName, speciality, experience, fees, startTime, endTime) values(?,?,?,?,?,?,?)";            

	public static final String UPDATEQUERY = "update doctor set fees=? where doctorId=?";
	
	public static final String DELETEQUERY = "delete from doctor where doctorId=?";

	public static final String QUERYBYID = "select * from doctor where doctorId=?";
	
	public static final String QUERYALL = "select * from doctor";

	public static final String QUERYBYSPECIALITY = "select * from doctor where speciality=?";

	public static final String QUERYBYSPECIALITYEXP = "select * from doctor where speciality=? and experience>=?";
	
	public static final String QUERYBYSPECIALITYFEE = "select * from doctor where speciality=? and fees<=?";
	
	public static final String QUERYBYAVAILABILITY = "select * from doctor where speciality=? and startTime<=? and endTime>=?";
}
