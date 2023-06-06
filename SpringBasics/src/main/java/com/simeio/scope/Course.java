package com.simeio.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@Scope("prototype")
public class Course {

	private String courseName;
	private String type;

	public String getCourseName() {
		return courseName;
	}

	@Value("${course.name}")
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getType() {
		return type;
	}

	@Value("${course.type}")
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", type=" + type + "]";
	}

}
