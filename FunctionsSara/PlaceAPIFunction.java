package Functions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Models.Distance;
import Models.GeoLocation;
import Models.Place;
import java.net.URLEncoder;
import java.text.ParseException;

public class PlaceAPIFunction {
	
	private static final String GOOGLE_PLACES_API = "AIzaSyDIYPezI29PWxdq_dQL0BsdH-1wI9YTAOs";
	public static ArrayList<Place> getPlace(ArrayList<String> PrefAlim,String type,ArrayList<Integer> allIds,String date,String dHeure,String fHeure) throws IOException, JSONException, SQLException, MalformedURLException, ParseException{
                long rating =0;
                ArrayList<Place> allPlace = new ArrayList<>();
		String now_opening = "NON MENTIONNER";
                System.out.println("User IDs in getPlace Function are : "+allIds.toString());
                for(int i=0 ; i<allIds.size() ; i++){
                    String transport = UserFunctions.getInfoUserFromId(allIds.get(i)).getTransport();
                    GeoLocation currentLocation = GeoLocationFunction.getLatLongAdresse(allIds.get(i));
                    String URL_PLACE_API = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+currentLocation.toString()+"&radius=6000&types="+type+"&name=";
                    StringBuilder stBuilder = new StringBuilder(URL_PLACE_API);
                    for(int j=0 ; i<PrefAlim.size();j++){
			stBuilder.append(PrefAlim.get(j));
                        if(j == PrefAlim.size() -1){
                            break;
                        }
			stBuilder.append("|");
                    }
                    System.out.println("request before key : "+stBuilder.toString());
                    stBuilder.append("&key="+GOOGLE_PLACES_API);
                    String ALL_URL;
                    ALL_URL = stBuilder.toString().replace(" ","%20");
                    System.out.println("URL PLACES IS : "+ALL_URL);
                    URL url = new URL(ALL_URL);
                    String html_output;
                    try (Scanner scan = new Scanner(url.openStream())) {
                    html_output = new String();
                    while(scan.hasNext()){
                    html_output += scan.nextLine();
                    }
                    }
                    JSONObject jsonObject = new JSONObject(html_output);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    System.out.println("Result size is : "+jsonArray.length());
                    
                    for(int k=0 ; k<jsonArray.length() ; k++){
			JSONObject obj = jsonArray.getJSONObject(k);
			JSONObject geometry = obj.getJSONObject("geometry");
			JSONObject locat = geometry.getJSONObject("location");
			double lat = locat.getDouble("lat");
			double lng = locat.getDouble("lng");
                        float LATT = Float.parseFloat(String.valueOf(lat));
                        float LON = Float.parseFloat(String.valueOf(lng));
                        System.out.println("Latt DOUBLE in placeFunction : "+lat);
                        System.out.println("Lngg DOUBLE in placeFunction : "+lng);
                        System.out.println("Latt FLOAT in placeFunction : "+LATT);
                        System.out.println("Lngg FLOAT in placeFunction : "+LON);
			GeoLocation geoLocat = new GeoLocation(lat, lng);
                        System.out.println("Before calcul duration");
			Distance distance = DistanceFunction.calculDurationDistannce(currentLocation, geoLocat,transport);
			System.out.println("After calcul duration");
                        String nom = obj.getString("name");
                        System.out.println("the name is : "+nom);
			String place_id = obj.getString("place_id");
                        String URL_MAP = PlaceTimeFunction.getUrlPlace(place_id);
			String vicinity = obj.getString("vicinity");
                        if(obj.has("rating")){
                            rating = obj.getLong("rating");
                            System.out.print("rating is : "+rating);
                        }
                        if(obj.has("opening_hours")){
                            JSONObject hours = obj.getJSONObject("opening_hours");
                                if(hours.has("open_now")){
                                    boolean open_now = hours.getBoolean("open_now");
                                    System.out.println("Opennow : "+open_now);
                                if(!open_now){
                                    now_opening = "Non";
                                }else{
                                    now_opening = "Oui";
                                }
                                }
                        }
                        System.out.println("Instance place");
                        boolean TimeDateBudgetVerif = PlaceTimeFunction.VerificationOuvertureFermetureBudget(place_id,date,dHeure, fHeure, allIds.get(i));
			if(TimeDateBudgetVerif){
                            Place place = new Place(nom, vicinity, place_id, type, now_opening, rating,distance,transport,URL_MAP);
                            System.out.println("Begin add");
                            System.out.println("Specific object is : "+place.toString());
                            allPlace.add(place);
                            System.out.println("Object added : "+i);
                        }
		}
                    
                }
                System.out.println("list array is : "+allPlace.toString());
		return allPlace;
	}
}
