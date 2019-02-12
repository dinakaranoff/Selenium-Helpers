package com.dina.rest;

public class GenericRestClientwithJercey {

		String server;
		String header;
		
		public GenericRestClient(String server,String header){
			this.server=server;
			this.header=header;
		}
		
		public Response post(String endpoint,T payload){
			Client client = ClientBuilder.newBuilder().build();
			Response response = client.target(server)
					.path(endpoint)
					.request()
					.header("Content-Type", header)
					.header("Accept", header)
					.post(Entity.entity(payload, header), Response.class);

			return response;
		}

		
		
//		public Response get(String endpoint){
//			Client client=ClientBuilder.newBuilder().build();
//			Response response=client.target(server)
//							  .path(endpoint)
//							  .request()
//							  .header("Accept", header)
//							  .get(Response.class);
//			return response;		
//		}
		
		
		
		public HttpResponse post(String uri,String payload ){

			DefaultHttpClient client;
			HttpResponse response = null;
			client=new DefaultHttpClient();
		//	HttpPost request=new HttpPost(uri); 
			HttpPost request=new HttpPost("http://localhost:8080/Test/rest/UserService/createAccount");
			
	        StringEntity entity = null;
			try {
				entity = new StringEntity("{\"id\":\"30\",\"name\":\"Dinakaran\",\"profession\":\"software\"}");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				 request.addHeader("content-type","application/json");
				 request.addHeader("accept","application/json");
				 request.setEntity(entity);
//				//
//				 response=client.execute(equest); ////test
//					HttpEntity ent=response.getEntity();
//					String va=EntityUtils.toString(ent);
//					System.out.println("POST Request is successful "+va);
	//
				  response=client.execute(request);
				  
				 int code=response.getStatusLine().getStatusCode();
				 if(code==201){
					System.out.println("POST Request is successful "+code);
				}else{				
					System.out.println("POST Request is Failed  "+code);
			}}
			
			catch (UnsupportedEncodingException e) {
				System.out.println("Json Data is wrong");
				e.printStackTrace();
			}catch (ClientProtocolException e) {
				 e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return response;
		
		}

		
	}

}
