package com.dina.rest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.dina.json.User;

public class UserServiceClient extends GenericRestClient{
	ObjectMapper mapper=new ObjectMapper();
	User user;
	HttpResponse response;
	private String basePath="https://localhost:8080/Test/rest/UserService/";
//	HttpPost request=new HttpPost("http://localhost:8080/Test/rest/UserService/createAccount");
//	payload = new StringEntity("{\"id\":\"30\",\"name\":\"Dinakaran\",\"profession\":\"software\"}");
	
	
	public UserServiceClient(String server, String header) {
		super(server, header);
	}

	private String getPath(String action){
		return basePath+action;
	}
	
	
	public User createUser(String action, String payload) throws Exception {
		String endpoint=getPath(action);
		response=post(endpoint,payload);
		if(response.getStatusLine().getStatusCode()==201){
			System.out.println("Post reqesut is successful "+action);
			user=mapper.readValue(response.getEntity().getContent(), User.class);
		}else{
			System.out.println("Post request is not successful "+action);
		}
		return user;
	}
	
	
	
	public User getUser(String action ) throws Exception {
		String endpoint=getPath(action);
		response=get(endpoint);
		if(response.getStatusLine().getStatusCode()==201){
			System.out.println("Post reqesut is successful "+action);
			user=mapper.readValue(response.getEntity().getContent(), User.class);			
		}else{
			System.out.println("Post request is not successful "+action);
		}
		return user;
	}
}
