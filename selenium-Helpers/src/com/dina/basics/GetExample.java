package com.dina.basics;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class GetExample {
	DefaultHttpClient client;
			
	public HttpResponse doGet(String uri){
		client=new DefaultHttpClient();
		HttpGet request=new HttpGet("http://localhost:8080/Test/rest/UserService/users");
		request.addHeader("accept","application/xml");
		HttpResponse response = null;
		try {
			 response=client.execute(request);						
		}catch (ClientProtocolException e) {
				System.out.println("Request excution failed");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Unable to establize connection");
				e.printStackTrace();
			}finally{
				if(client!=null)
					client.close();
				}
		return response;
		}
	
	public void  doGetXML(String uri,String header){
		client=new DefaultHttpClient();
		HttpGet request=new HttpGet(uri);
		if(header!=null){
		request.addHeader("accept",header);
		}
		try {
			HttpResponse response=client.execute(request);
			int status=response.getStatusLine().getStatusCode();
			
			if(response.getStatusLine().getStatusCode()!=200){
				System.out.println("Request Failed with status code "+status);
			}else{
				HttpEntity entity =response.getEntity();
				String content=EntityUtils.toString(entity);		
				System.out.println(content);
			}
		} catch (ClientProtocolException e) {
			System.out.println("Request excution failed");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to establize connection");
			e.printStackTrace();
		}finally{
			if(client!=null)
			client.close();
		}

	}

	

	private void doGetJSOn(String uri,String header) {
		client=new DefaultHttpClient();
		HttpGet request=new HttpGet(uri);
		if(header!=null){
			request.addHeader("accept",header);
			}
				try {
			HttpResponse response=client.execute(request);
			int code=response.getStatusLine().getStatusCode();
		
			if(response.getStatusLine().getStatusCode()!=200){
				System.out.println("Get Request is failed with status "+code);
			}
			else{					
			HttpEntity entity=response.getEntity();
			String str=EntityUtils.toString(entity);
			System.out.println(str);
			}
		} catch (ClientProtocolException e) { //when hpp violation happens, circular redirection time
			System.out.println("Get Api request failed");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Get Api request failed with IO exception");
			e.printStackTrace();
		}finally{
			if(client!=null)
			client.close();
		}
	}

	
	
	
	public static void main(String[] args) {
		GetExample ex=new GetExample();
//get with XML format
		String uri="http://localhost:8080/Test/rest/UserService/users";
/*		ex.doGetXML(uri,"application/xml");
//get with JSON Format		
		uri="http://localhost:8080/Test/rest/UserService/users";
		ex.doGetJSOn(uri,"application/json");
//get with no MIME type but same url mapping. Default is XML
		uri="http://localhost:8080/Test/rest/UserService/users";
		ex.doGetJSOn(uri,"");
//get with invalid MIME. Error code 406
		uri="http://localhost:8080/Test/rest/UserService/WrongMIME";
		ex.doGetJSOn(uri,"application/json");
//get invalid resource. Error code 404. No condent. Not found. if we give any wrong value after port section it will give 404
		uri="http://localhost:8080/test/Test/UserService/Dummy";
		ex.doGetJSOn(uri,"application/json");
//java.net.UnknownHostException. if we give wrong host
		uri="http://localhot:8080/test/Test/UserService/Dummy";
		ex.doGetJSOn(uri,"application/json");
// Method Not allowed 405, Client side and server side error
//the server may be misconfigured and handling requests improperly.The resource is not to handle the request. 
//Or instead of GET Pass POST you will get 405
		uri="http://localhost:8080/Test/rest/UserService/";
		ex.doGetJSOn(uri,"application/json");

//Get with Querystring url parameters (1 0r 2)
//Status success code: 200		
		uri="http://localhost:8080/Test/rest/UserService/users/1";
		ex.doGetJSOn(uri,"application/json");

//Get with Querystring wrong url parameters (2)
//Status success code: 204. No Content
//This allows a server to indicate that the action has been successfully applied to the target resource
		uri="http://localhost:8080/Test/rest/UserService/users/3";
		ex.doGetJSOn(uri,"application/json");

*/		
//Get data fromm User table
		int id=25;
		uri=uri+"/"+id;
		ex.doGetJSOn(uri, "application/json");
		
	}

	

	}
