package com.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonDemo {

	public static void main(String[] args) {
		JsonObject parentJsonObj = new JsonObject();
		parentJsonObj.addProperty("name", "jyotiranjan");
		parentJsonObj.addProperty("age", "24");
		JsonArray address = new JsonArray();
		JsonArray contact = new JsonArray();
		JsonObject addressObj = new JsonObject();
		JsonObject contactObj = new JsonObject();
		addressObj.addProperty("permanent", "Odisha");
		addressObj.addProperty("correspondence", "Pune");
		contactObj.addProperty("home", "1234567890");
		contactObj.addProperty("work", "0987654321");
		address.add(addressObj);
		contact.add(contactObj);
		parentJsonObj.add("address", address);
		parentJsonObj.add("contact", contact);
		
		System.out.println(parentJsonObj.toString());

	}

}
