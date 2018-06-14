package com.test;

import javax.ws.rs.core.MediaType;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JsonClient {
	public static void main(String[] args) {
		try {
			String url = "http://localhost:3030/RestDemo/rest/demo/customJson";
			/*Client client = ClientBuilder.newClient();
			WebTarget target = client.target(new URI(url));
			Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildGet();
			Response response = invocation.invoke();*/
			Client client = Client.create();
			
			WebResource webResource = client.resource(url);
			ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
			
			if(response.getStatus()==200) {
				String clientResponse = response.getEntity(String.class);
				JsonParser parser = new JsonParser();
				JsonElement elem = parser.parse(clientResponse);
				JsonObject obj = elem.getAsJsonObject();
				System.out.println("obj : " + obj);
				System.out.println("name : " + obj.get("name").getAsString());
				System.out.println("age : " + obj.get("age").getAsInt());
				JsonObject add = obj.get("address").getAsJsonObject();
				System.out.println("permanent : " + add.get("permanent").getAsString());
				System.out.println("correspondence : " + add.get("correspondence").getAsString());
				JsonObject contact = obj.get("contact").getAsJsonObject();
				System.out.println("home : " + contact.get("home").getAsString());
				System.out.println("work : " + contact.get("work").getAsString());
				System.out.println("Processing end");
			}
			
		}catch(Exception e) {
			System.out.println("Inside Catch Block");
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}
	}

}
