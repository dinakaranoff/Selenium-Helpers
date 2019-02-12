package com.dina.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_Object {

	
	public void createJson(){
		
	}
	
	public void readJson(String path){
		
		path=System.getProperty("user.home")+File.separator +"workspace"+File.separator+"Selenium"+File.separator+"src"+File.separator+"resource"+File.separator +path;
		FileReader reader = null;
		try {
			reader = new FileReader(new File(path));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONParser par=new JSONParser();
		JSONObject object;
		
		/*Read inner JSON Object . Parser reader only once */
		try {
//			object = (JSONObject) par.parse(reader);
//			String age=object.get("age").toString();
//			System.out.println("Age "+age);			
//			JSONObject user=(JSONObject) object.get("User");			
//			System.out.println("user name "+user.get("name").toString());
//			System.out.println("user Id "+user.get("id"));
			
			/*Read JSON Array */
			JSONObject parent=(JSONObject) par.parse(reader);	
			JSONArray arr=(JSONArray) parent.get("User");
			for(int i=0;i<arr.size();i++){
			JSONObject user=(JSONObject) arr.get(i);
			System.out.println("user name "+user.get("name").toString());
			System.out.println("user Id "+user.get("id"));		
			
			/*set this to object*/
			User actualUser=new User();
			actualUser.setName(user.get("name").toString());
			actualUser.setId((Integer)user.get("id"));
			//return actualUser;
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void createJson(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JSON_Object().readJson("Org.json");
	}

}
