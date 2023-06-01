package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.javabased.Player;

@SpringBootApplication
public class SpringBootBasicApplication implements CommandLineRunner{

	/*ShapeFactory shapeFactory;
	
	@Autowired
	public void setShapeFactory(ShapeFactory shapeFactory) {
		this.shapeFactory = shapeFactory;
	}
	
	@Autowired
	Student student;*/
	
	@Autowired
	Player player;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//shapeFactory.printArea("rectangle", 10, 20);
		//System.out.println(student);
		player.showOngoingMatches().forEach(System.out::println);;
		}		

}
