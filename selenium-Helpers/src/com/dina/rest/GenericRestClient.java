package com.dina.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class GenericRestClient {

	DefaultHttpClient client;
	HttpResponse response = null;
	String server;
	String header;

	public GenericRestClient(String server,String header){
		this.server=server;
		this.header=header;
		if(client!=null){
			client=new DefaultHttpClient();
		}
	}


	public HttpResponse post(String uri,String payload ) throws Exception  {
		HttpPost request=new HttpPost(uri); 
		request.addHeader("content-type",header);
		request.addHeader("accept",header);
		StringEntity entity = null;
		entity = new StringEntity(payload);
		request.setEntity(entity);
		response=client.execute(request);
		HttpEntity responseEntity=response.getEntity();
		int code=response.getStatusLine().getStatusCode();
		return response;
	}

	public HttpResponse get(String uri ) throws Exception  {
		HttpGet request=new HttpGet(uri); 
		request.addHeader("content-type",header);
		request.addHeader("accept",header);
		StringEntity entity = null;
		response=client.execute(request);
		HttpEntity responseEntity=response.getEntity();
		int code=response.getStatusLine().getStatusCode();
		return response;

	}




}
