package com.dina.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dina.json.User;

public class UserserviceTests extends RestHelper {
	
	RestHelper helper;
	User user;
	String payload;
	@BeforeTest
	public void init(){
		helper=new RestHelper(); //Need to pass class here
		System.out.println("Helper Class is initialized");
		user=loadInput("User.json",user); //read as object
		payload=parseJsonToString("user.json");//read as payload
	
	}
	
	
	@Test
	public void createUserTest(){
		String action="createUser";
		try {
			User user=helper.createUser(action,payload);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	Assert.assertEquals(helper.getClass().g, "201");		
	}
	
	
	
	@Test
	public void getUsers(){
		String action="getUsers";
		try {
			User user=helper.getUser(action);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	Assert.assertEquals(helper.getClass().g, "201");		
	}
	

}
