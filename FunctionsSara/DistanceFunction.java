package Functions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Models.Distance;
import Models.GeoLocation;

public class DistanceFunction {
	
	public static final String GOOGE_MATRIX_API_KEY = "AIzaSyAWwk5Inr0C_1p9ZBUrcK4Gdrna9g7UjKI";
	
	public static Distance calculDurationDistannce(GeoLocation startLocation,GeoLocation endLocation,String transport) throws IOException, JSONException{
		String HTTP_URL ="";
                System.out.println("Transport is : "+transport);
                System.out.println("startLocation : "+startLocation.toString());
                System.out.println("endLocation : "+endLocation.toString());
		switch (transport) {
                case "voiture":
                    HTTP_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+startLocation.toString()+"&destinations="+endLocation.toString()+"&mode=driving&key="+GOOGE_MATRIX_API_KEY;
                    break;
                case "train":
                    HTTP_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+startLocation.toString()+"&destinations="+endLocation.toString()+"&mode==transit&transit_mode=train&key="+GOOGE_MATRIX_API_KEY;
                    break;
                case "tgv":
                    HTTP_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+startLocation.toString()+"&destinations="+endLocation.toString()+"&mode==transit&transit_mode=subway&key="+GOOGE_MATRIX_API_KEY;
                    break;
                case "tramway":
                    HTTP_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+startLocation.toString()+"&destinations="+endLocation.toString()+"&mode==transit&transit_mode=tram&key="+GOOGE_MATRIX_API_KEY;
                    break;
                case "bus":
                    HTTP_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+startLocation.toString()+"&destinations="+endLocation.toString()+"&mode==transit&transit_mode=bus&key="+GOOGE_MATRIX_API_KEY;
                    break;
                case "walking":
                    HTTP_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+startLocation.toString()+"&destinations="+endLocation.toString()+"&mode=walking&key="+GOOGE_MATRIX_API_KEY;
                    break;
                case "velo":
                    HTTP_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+startLocation.toString()+"&destinations="+endLocation.toString()+"&mode=bicycling&key="+GOOGE_MATRIX_API_KEY;
                    break;
                default:
                    break;
            }
                System.out.println("before url");
		URL url = new URL(HTTP_URL);
                String html_output;
                System.out.println("Begin scanner");
            try (Scanner scan = new Scanner(url.openStream())) {
                html_output = new String();
                while(scan.hasNext()){
                    html_output += scan.nextLine();
                }
            }
		System.out.print("Distance json object");
                JSONObject jsonObject = new JSONObject(html_output);
		JSONArray jsonArray = jsonObject.getJSONArray("rows");
                JSONObject obj = jsonArray.getJSONObject(0);
                JSONArray elementArray = obj.getJSONArray("elements");
                JSONObject startGetInfo = elementArray.getJSONObject(0);
                JSONObject objDistance = startGetInfo.getJSONObject("distance");
                JSONObject objDuration = startGetInfo.getJSONObject("duration");
                String DIST = objDistance.getString("text");
                String DUR = objDuration.getString("text");
                Distance distance = new Distance(DIST,DUR);
                System.out.println("Final function distance");
		return distance;
	}
}
