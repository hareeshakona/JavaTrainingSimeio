package com.hotelapp.util;

public class Queries {

	public static final String HOTELINSERTQUERY = "INSERT INTO hotel(hotelId, hotelName, city, rating, phone) VALUES(HOTEL_SEQ.NEXTVAL,?,?,?,?)";

	public static final String HOTELUPDATEQUERY = "UPDATE hotel SET phone=? WHERE hotelId=?";

	public static final String HOTELDELETEQUERY = "DELETE FROM hotel WHERE hotelId=?";

	public static final String HOTELQUERYBYID = "SELECT * FROM hotel WHERE hotelId=?";

	public static final String HOTELQUERYBYNAME = "SELECT * FROM hotel WHERE hotelName=?";

	public static final String HOTELQUERYALL = "SELECT * FROM hotel";

	public static final String HOTELQUERYBYNAMELIKE = "SELECT * FROM hotel WHERE hotelName like ?";

	public static final String HOTELQUERYBYCITY = "SELECT * FROM hotel WHERE city=?";

	public static final String HOTELQUERYBYCITYRATING = "SELECT * FROM hotel WHERE city=? AND rating>=?";

	public static final String HOTELQUERYBYCITYANDNAME = "SELECT * FROM hotel WHERE city=? AND hotelName=?";

	public static final String HOTELQUERYBYCITYROOMTYPE = "SELECT DISTINCT h.hotelId, h.hotelName, h.city, h.rating, h.phone FROM hotel h inner join room r on h.hotelId=r.hotelId WHERE h.city=? AND r.roomType=?";

	public static final String HOTELQUERYBYCITYROOMCOST = "SELECT DISTINCT h.hotelId, h.hotelName, h.city, h.rating, h.phone FROM hotel h inner join room r on h.hotelId=r.hotelId WHERE h.city=? AND r.costPerNight<=?";

	public static final String ROOMINSERTQUERY = "INSERT INTO room(roomId, roomNumber, roomType, capacity, costPerNight, hotelId) VALUES (ROOM_SEQ.NEXTVAL,?,?,?,?,?)";

	public static final String ROOMUPDATEQUERY = "UPDATE room SET costPerNight=? WHERE roomId=?";

	public static final String ROOMDELETEQUERY = "DELETE FROM room WHERE roomId=?";

	public static final String ROOMQUERYBYID = "SELECT * FROM room WHERE roomId=?";

	public static final String ROOMQUERYALL = "SELECT * FROM room";

	public static final String ROOMQUERYBYHOTELID = "SELECT * FROM room WHERE hotelId=?";

	public static final String ROOMQUERYBYROOMNUMBER = "SELECT * FROM room WHERE roomNumber=?";

	public static final String ROOMQUERYBYROOMTYPE = "SELECT * FROM room WHERE roomType=?";

	public static final String ROOMQUERYBYCAPACITY = "SELECT * FROM room WHERE capacity=?";

	public static final String ROOMQUERYBYMAXCOST = "SELECT * FROM room WHERE costPerNight<=?";

	public static final String ROOMQUERYBYTYPEANDCAPACITY = "SELECT * FROM room WHERE roomType=? AND capacity=?";

	public static final String ROOMQUERYBYTYPEANDMAXCOST = "SELECT * FROM room WHERE roomType=? AND costPerNight<=?";

	public static final String RESVINSERTQUERY = "INSERT INTO reservation(reservationId, roomId, userId, checkInDate, checkOutDate, amount, paymentStatus) VALUES (RESERVATION_SEQ.NEXTVAL,?,?,?,?,?,?)";

	public static final String RESVUPDATEQUERY = "UPDATE reservation SET paymentStatus=? WHERE reservationId=?";

	public static final String RESVDELETEQUERY = "DELETE FROM reservation WHERE reservationId=?";

	public static final String RESVQUERYBYID = "SELECT * FROM reservation WHERE reservationId=?";

	public static final String RESVQUERYALL = "SELECT * FROM reservation";

	public static final String RESVQUERYBYROOMID = "SELECT * FROM reservation WHERE roomId=?";

	public static final String RESVQUERYBYUSERID = "SELECT * FROM reservation WHERE userId=?";

	public static final String RESVQUERYBYPAYMENTSTATUS = "SELECT * FROM reservation WHERE paymentStatus=?";

	public static final String RESVQUERYBYUSERIDANDPAYMENT = "SELECT * FROM reservation WHERE userId=? AND paymentStatus=?";

	public static final String USERINSERTQUERY = "INSERT INTO users(userId, firstName, middleName, lastName, dateOfBirth, city, email, securityQuestion, securityAnswer, userName, password) VALUES (USERS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";

	public static final String USERUPDATEQUERY = "UPDATE users SET securityQuestion=?, securityAnswer=? WHERE userName=?";
	
	public static final String USERCHANGEPASSWORDQUERY = "UPDATE users SET password=? WHERE userName=?";

	public static final String USERDELETEQUERY = "DELETE FROM users WHERE userId=?";

	public static final String USERQUERYALL = "SELECT * FROM users";

	public static final String USERQUERYBYID = "SELECT * FROM users WHERE userId=?";

	public static final String USERQUERYBYUSERNAME = "SELECT * FROM users WHERE userName=?";

	public static final String USERQUERYBYCITY = "SELECT * FROM users WHERE city=?";

	public static final String ACCESSLOGINSERTQUERY = "INSERT INTO accesslog(logId, userName, activity, attemptedAt, status, numberOfAttempts) VALUES (ACCESSLOG_SEQ.NEXTVAL,?,?,?,?,?)";

}
