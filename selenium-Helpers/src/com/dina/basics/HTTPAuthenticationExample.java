package com.dina.basics;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HTTPAuthenticationExample {

	public void  base64Authenticate(String username,String password){ // HTTP Basic Authentication
		String uri="https://postman-echo.com/basic-auth";
		DefaultHttpClient client=new DefaultHttpClient();
		HttpGet request=new HttpGet(uri);
		String authString=username+":"+password;  //username:password
		String authkey=new String(Base64.encodeBase64(authString.getBytes()));  //Convert to encode  0's and 1's base 64 format
		//request.addHeader("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==");   //Success Base64 format
		request.addHeader("Authorization", "Basic "+authkey);           //Added into header "Authorization", "Basic "base64 
		try {
			HttpResponse response=client.execute(request);
			if(response.getStatusLine().getStatusCode()==200){
				System.out.println("Authenticated");
			}else{
				System.out.println("Not Authenticated "+response.getStatusLine().getStatusCode());
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void authAPiKey(){   // API key authentication
		String keyName="X-DC-DEVKEY";   //api key name
		String keyValue="BG2AHFKWX5BZ2YKLUCSCBFOLAFRRKDDFWTLJWTMRP4ZLLWN7SVNDCPMWQFRI5G6FZQFJW2R6TPSHLMSAN"; //api key value 
		String uri="https://localhost.digicert.com/services/v2/organization/recent";
		DefaultHttpClient client=new DefaultHttpClient();
		HttpGet request=new HttpGet(uri); 
		request.addHeader(keyName,keyValue); //api key is added in header     
		request.addHeader("accept","application/json");
		try {
			HttpResponse response=client.execute(request);
			if(response.getStatusLine().getStatusCode()==200){
				System.out.println("ApI key authentication is success");
				HttpEntity ent=response.getEntity();
				String str=EntityUtils.toString(ent);
				System.out.println(str);				
			}else{
				System.out.println("ApI key authentication is failed "+response.getStatusLine().getStatusCode());
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	public static void main(String[] args) {
		HTTPAuthenticationExample obj=new HTTPAuthenticationExample();
		
		//Successfull authenticatoin
		
		//obj.base64Authenticate("postman", "password");
		//obj.authAPiKey();
	}

}
