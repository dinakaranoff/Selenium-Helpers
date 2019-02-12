package com.dina.basics;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.*;  

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class PostExample {
	
	DefaultHttpClient client;
	
	
	public void createAccount(String uri){
		client=new DefaultHttpClient();
		HttpPost request=new HttpPost(uri);
		StringEntity entity = null;
		try {
			 entity=new StringEntity("{\"id\":\"30\",\"name\":\"Dinakaran\",\"profession\":\"software\"}");
			 request.addHeader("content-type","application/json");
			 request.addHeader("accept","application/json");
			 request.setEntity(entity);
			 HttpResponse response=client.execute(request);
			 int code=response.getStatusLine().getStatusCode();
			 if(code==201){
				System.out.println("POST Request is successful "+code);
			}else{				
				System.out.println("POST Request is Failed  "+code);
		}
		} 
		catch (UnsupportedEncodingException e) {
			System.out.println("Json Data is wrong");
			e.printStackTrace();
		}catch (ClientProtocolException e) {
			 e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void createResult(String uri){
		client=new DefaultHttpClient();
		HttpPost request=new HttpPost(uri);
		StringEntity entity = null;
		try {
			 entity=new StringEntity("{\"id\":\"30\",\"name\":\"Dinakaran\",\"profession\":\"software\"}");
			 request.addHeader("content-type","application/json");
			 request.addHeader("accept","application/json");
			 request.setEntity(entity);
			 HttpResponse response=client.execute(request);
			 int code=response.getStatusLine().getStatusCode();
			 if(code==201){
				System.out.println("POST Request is successful "+code);
			}else{				
				System.out.println("POST Request is Failed  "+code);
		}
		} 
		catch (UnsupportedEncodingException e) {
			System.out.println("Json Data is wrong");
			e.printStackTrace();
		}catch (ClientProtocolException e) {
			 e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void makeConnection(){

		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","cfcNEBdUm6QerR6oo2UM");
		Statement stmt=con.createStatement();  
	    stmt.execute("insert into User (EMPID,NAME,JOB) values (2,'sdssd','llll')");
	    
		//	ResultSet rs=stmt.executeQuery("select * from User");  
		//while(rs.next()) { 
		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		con.close();  
	//	}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	public static void main(String[] args) {
		PostExample obj =new PostExample();
		
		//201 error code.  Created
		String uri="http://localhost:8080/Test/rest/UserService/createAccount";
		obj.createAccount(uri);
		//obj.makeConnection();
		
		//404 error code
		uri="http://localhost:8080/Test/rest/UserService/createAccout";
		//obj.createAccount(uri);
		
		//405 error code
		uri="http://localhost:8080/Test/rest/UserService/";
		//obj.createAccount(uri);
		
		//405 post instead of get
		uri="http://localhost:8080/Test/rest/UserService/users";
		//obj.createAccount(uri);

		
		//406 post instead of get .If we pass wrong MIME content type (XML istead of JSON)
		uri="http://localhost:8080/Test/rest/UserService/createAccout";
	//	obj.createAccount(uri);

		
		//CreateResult
		uri="http://localhost:8080/Test/rest/UserService/createResult";
		//obj.createAccount(uri);
		
		
	}

}
