package com.dina.rest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

public class MyResponseHandler implements ResponseHandler<MyResponse> {

	@Override
	public MyResponse handleResponse(HttpResponse response) throws ClientProtocolException,
			IOException {
		
		
		return null;
	}

}
