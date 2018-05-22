package Functions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Models.GeoLocation;
import java.util.ArrayList;

public class GeoLocationFunction {
	
	//r�cup�rer l'alltitude et la longitude d'une adrresse
	
	private static final String GEO_LOCATION_APP_KEY = "AIzaSyBSJR94wAc1xBJDo8qZNn2WlotqImtcy3I";
	public static GeoLocation getLatLongAdresse(int idUser) throws SQLException, IOException, JSONException{
		GeoLocation location = null;
                String adresse = UserFunctions.getInfoUserFromId(idUser).getAdresse().replace(" ","+");
                System.out.println("adress from DB : "+adresse);
                String URL_GEO_CODING = "https://maps.googleapis.com/maps/api/geocode/json?address="+adresse+"&key="+GEO_LOCATION_APP_KEY;
                URL url = new URL(URL_GEO_CODING);
                String html_output;
                try (Scanner scan = new Scanner(url.openStream())) {
                    html_output = new String();
                        while(scan.hasNext()){
                            html_output += scan.nextLine();
                        }
                }
                JSONObject jsonObject = new JSONObject(html_output);
                JSONArray jsonArray = jsonObject.getJSONArray("results");
                JSONObject objectAddress = jsonArray.getJSONObject(0);
                JSONObject geometry = objectAddress.getJSONObject("geometry");
                JSONObject locat = geometry.getJSONObject("location");
                double dLat = locat.getDouble("lat");
                double dLng = locat.getDouble("lng");
                float LATT = Float.parseFloat(String.valueOf(dLat));
                float LNG = Float.parseFloat(String.valueOf(dLng));
                System.out.println("Lat in float is : "+LATT);
                System.out.println("Lon in flaot is : "+LNG);
                location = new GeoLocation(dLat,dLng);
                return location;
    }
}
