package com.dina.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ParseJson_jakson {

	public  void JsonToObject(String path){
		//InputStream input=getClass().getClassLoader().getResourceAsStream(path); 
		
		path=System.getProperty("user.home")+File.separator +"workspace"+File.separator+"Selenium"+File.separator+"src"+File.separator+"resource"+File.separator +path;
		FileReader reader = null;
		try {
			reader = new FileReader(new File(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			ObjectMapper mapper=new ObjectMapper();
			User user=mapper.readValue(reader,User.class);			
			System.out.println("JSON to object is successfull ");
			System.out.println(user);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public  void JsonToObject2(String path){
		//InputStream input=getClass().getClassLoader().getResourceAsStream(path); 
		
		path=System.getProperty("user.home")+File.separator +"workspace"+File.separator+"Selenium"+File.separator+"src"+File.separator+"resource"+File.separator +path;
		FileReader reader = null;
		try {
			reader = new FileReader(new File(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			ObjectMapper mapper=new ObjectMapper();
			Org org=mapper.readValue(reader,Org.class);			
			System.out.println("JSON to object is successfull ");
			System.out.println(org.getAge());
			System.out.println(org.getUser().getName());
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
		public static void main(String[] args) {
	//	new ParseJson().JsonToObject("User.json");
		new ParseJson_jakson().JsonToObject2("Org.json");

	}

}
