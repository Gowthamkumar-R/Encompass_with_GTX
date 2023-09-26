package org.api.stepDefinitions;

import java.util.LinkedHashMap;

import com.google.gson.Gson;

public class OrderedJsonObject {

	private LinkedHashMap<String, Object> jsonMap = new LinkedHashMap<>();

	public void put(String key, Object value) {
		jsonMap.put(key, value);
	}

	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(jsonMap);
	}
}