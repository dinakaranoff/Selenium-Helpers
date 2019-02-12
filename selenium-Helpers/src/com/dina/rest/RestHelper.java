package com.dina.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.BeforeSuite;

import com.dina.json.User;

public class RestHelper {
	CofingManger config;
	UserServiceClient userClient;
	String header="application/json";

	public  RestHelper(){
		config=CofingManger.getConfig();
		userClient=new UserServiceClient(config.getServer(),header);
	}

	private UserServiceClient getUserClient(){
		return userClient;
	}

	public User createUser(String action,String payload) throws Exception {		
	return userClient.createUser(action,payload);
	}
	
	public User loadInput(String file, User user){
		String jsonPath=System.getProperty("user.home")+File.separator +"workspace"+File.separator+"Selenium"+File.separator+"src"+File.separator+"resource"+File.separator;
		//InputStream stream=getClass().getClassLoader().getResourceAsStream(jsonPath+"User.json");
		InputStream stream=getClass().getClassLoader().getResourceAsStream("resource/User.json");
		ObjectMapper mapper=new ObjectMapper();
		try {
			user=mapper.readValue(stream, User.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to parse User.json file");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to Map User.json file");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to read User.json file");
			e.printStackTrace();
		}	
		return user;
	}

	
	public String ObjectToString(Object obj){
		ObjectMapper mapper=new ObjectMapper();
		String payload = null;
		try {
			payload = mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return payload;

	}
	
	public String parseJsonToString(String fileName){
		String jsonPath=System.getProperty("user.home")+File.separator +"workspace"+File.separator+"Selenium"+File.separator+"src"+File.separator+"resource"+File.separator;
		InputStream stream=getClass().getClassLoader().getResourceAsStream("resource/User.json");
		return stream.toString();		
	}


}
