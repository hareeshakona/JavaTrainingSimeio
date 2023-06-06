package com.example.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	//Pass query parameters as in http://localhost:8080/welcome?name=Hareesha&city=Bangalore
	@GetMapping("/welcome")
	public String welcomeUser(String name,String city) {
		return "Welcome "+name+" to "+city;
	}

	@GetMapping("/greet/{username}/{city}")
	public String greetUser(@PathVariable("username")String name,@PathVariable("city")String city) {
		return "Welcome "+name+" to "+city;
	}
	
	@GetMapping("/courses/{type}")
	public List<String> viewCourses(@PathVariable("type")String type) {
		if(type.equals("web"))
			return Arrays.asList("Html","Jsp","Angular","Nodejs");
		else
			return Arrays.asList("Mysql","Oracle","Sybase");
	
	}
	
	@GetMapping("/cities")
	public Map<String,List<String>> showCities(@RequestParam("mstate") String state) {
		List<String> andhraCities = Arrays.asList("Kakinada","Visakhapatnam","Rajahmundry");	
		List<String> karnatakaCities = Arrays.asList("Bangalore","Mysore","Mangalore");
		List<String> tamilnaducities = Arrays.asList("Chennai","Madurai","Coimbatore");
		Map<String,List<String>> stateCities = new HashMap<String,List<String>>();
		if(state.equals("AndhraPradesh"))
			stateCities.put("AndhraPradesh", andhraCities);
		else if(state.equals("Karnataka"))
			stateCities.put("Karnataka", karnatakaCities);
		else if(state.equals("TamilNadu"))
			stateCities.put("TamilNadu", tamilnaducities);
		else stateCities.put("other", Arrays.asList("no cities available"));
		return stateCities;	
			
	}
	
	@GetMapping("/view-cities-only")
	public List<String> showCitiesOnly(@RequestParam("state") String state) {
		Map<String,List<String>> cities = new HashMap<String,List<String>>();
		cities.put("AndhraPradesh", Arrays.asList("Kakinada","Visakhapatnam","Rajahmundry"));
		cities.put("TamilNadu", Arrays.asList("Chennai","Madurai","Coimbatore"));
		cities.put("Karnataka", Arrays.asList("Bangalore","Mysore","Mangalore"));
		//cities.put("other", Arrays.asList("no cities available"));
		return cities.getOrDefault(state, Arrays.asList("no cities available"));
		
		/*if(cities.containsKey(state))
			return cities.get(state);
		else return cities.get("other");*/
	}
	
	@GetMapping("/show-states-only")
	public Set<String> showStatesOnly() {
		Map<String,List<String>> cities = new HashMap<String,List<String>>();
		cities.put("AndhraPradesh", Arrays.asList("Kakinada","Visakhapatnam","Rajahmundry"));
		cities.put("TamilNadu", Arrays.asList("Chennai","Madurai","Coimbatore"));
		cities.put("Karnataka", Arrays.asList("Bangalore","Mysore","Mangalore"));
		cities.put("other", Arrays.asList("no cities available"));
		
		return cities.keySet();
	}
	
}
