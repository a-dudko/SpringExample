package by.bsu.fpmi.service;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CustomJSONParser {

	private static final String STATUS = "status";
	private static final String OK = "OK";
	private static final String RESULTS = "results";
	private static final String GEOMETRY = "geometry";
	private static final String LOCATION = "location";
	private static final String LATITUDE = "lat";
	private static final String LONGITUDE = "lng";
	
	public static HashMap<String, Double> getLatLong(String json) {
		JSONParser parser = new JSONParser();
		HashMap<String, Double> latLong = new HashMap<String, Double>();
		try {
			JSONObject obj = (JSONObject) parser.parse(json);
			String status = (String)obj.get(STATUS);
			if (status.equals(OK)) {
				JSONArray results = (JSONArray)obj.get(RESULTS);
				JSONObject firstResult = (JSONObject)results.get(0);
				JSONObject geometry = (JSONObject)firstResult.get(GEOMETRY);
				JSONObject location = (JSONObject)geometry.get(LOCATION);
				Double latitude = Double.valueOf((String)location.get(LATITUDE));
				Double longitude = Double.valueOf((String)location.get(LONGITUDE));
				latLong.put(LATITUDE, latitude);
				latLong.put(LONGITUDE, longitude);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return latLong;
	}
}
