package com.hotelapp.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.hotelapp.model.User;

@Component
public class CsvHelper {

	public static final String TYPE = "text/csv";
	public static String[] headers = { "firstName", "middleName", "lastName", "dateOfBirth", "city", "email",
			"securityQuestion", "securityAnswer" };

	public List<User> getUserList(String fileName) {
		List<User> users = new ArrayList<>();
		try (FileReader reader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(reader);
				CSVParser parser = new CSVParser(bufferedReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());) {

			List<CSVRecord> records = parser.getRecords();
			for (CSVRecord csvRecord : records) {
				String firstName = csvRecord.get("firstName");
				String middleName = csvRecord.get("middleName");
				String lastName = csvRecord.get("lastName");
				LocalDate dateOfBirth = LocalDate.parse(csvRecord.get("dateOfBirth"));
				String city = csvRecord.get("city");
				String email = csvRecord.get("email");
				String securityQuestion = csvRecord.get("securityQuestion");
				String securityAnswer = csvRecord.get("securityAnswer");
				User user = new User(firstName, middleName, lastName, dateOfBirth, city, email, securityQuestion,
						securityAnswer);
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
