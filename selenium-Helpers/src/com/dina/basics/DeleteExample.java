package com.dina.basics;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class DeleteExample {
	
	DefaultHttpClient client=null;
	public void put(String uri){
		StringEntity entity=null;
		client=new DefaultHttpClient();
		HttpDelete put=new HttpDelete(uri);
		put.addHeader("Content-Type","application/json");
		put.addHeader("accept","application/json");
		try {
			entity=new StringEntity("{\"id\":\"39\",\"name\":\"Dinakaran\",\"profession\":\"software\"}");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		put.setEntity(entity);
		try {
			HttpResponse response=client.execute(put);
			System.out.println(response.getStatusLine().getStatusCode());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public static void main(String[] args) {
		String uri="http://localhost:8080/Test/rest/UserService/createAccount";

		DeleteExample put=new DeleteExample();
		
		put.put(uri);
	}

}
