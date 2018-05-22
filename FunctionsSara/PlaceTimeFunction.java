/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author lenovo
 */
public class PlaceTimeFunction {
    
    public static final String GOOGLE_PLACE_DETAILS_API = "AIzaSyDIYPezI29PWxdq_dQL0BsdH-1wI9YTAOs";
    //méthode pour vérifier si un lieu est ouvert du début et a la fin de la soirée
    public static boolean VerificationOuvertureFermetureBudget(String placeId,String date,String debutHeure,String finHeure,int userId) throws MalformedURLException, IOException, ParseException, JSONException, SQLException{
        int price_level = 4;
        Date startHour = null;
        Date endHour = null;
        Date placeStartHour = null;
        Date placeEndHour = null;
        boolean confirmation = false;
        Date dateEntred = null;
        DateFormat foramt = new SimpleDateFormat("yyyy-MM-dd");
        dateEntred = foramt.parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(dateEntred);
        double budget = UserFunctions.getInfoUserFromId(userId).getBudget();
        int levelBudget = getLevelPriceBasedBudget(budget);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("Day of week : "+dayOfWeek);
        String HTTP_URL = "https://maps.googleapis.com/maps/api/place/details/json?placeid="+placeId+"&key="+GOOGLE_PLACE_DETAILS_API;
        URL url = new URL(HTTP_URL);
        String html_output;
        try (Scanner scan = new Scanner(url.openStream())) {
            html_output = new String();
                while(scan.hasNext()){
                    html_output += scan.nextLine();
                }
        }
        JSONObject obj = new JSONObject(html_output);
        if(obj.has("result")){
            JSONObject result = obj.getJSONObject("result");
        boolean price = false;
        if(result.has("price_level")){
            price_level = result.getInt("price_level");
        }
        if(result.has("opening_hours")){
            JSONObject opening_hours = result.getJSONObject("opening_hours");
        JSONArray periods = opening_hours.getJSONArray("periods");
        if(dayOfWeek < periods.length()){
            return true;
        }else{
            JSONObject day = periods.getJSONObject(dayOfWeek-1);
        JSONObject objectOpen = day.getJSONObject("open");
        JSONObject objectClose = day.getJSONObject("close");
        String timeClose = objectClose.getString("time");
        String timeOpen = objectOpen.getString("time");
        String correctTimeClose = timeClose.substring(0,2)+":"+timeClose.substring(2,timeClose.length());
        String correctTimeOpen = timeOpen.substring(0,2)+":"+timeOpen.substring(2,timeOpen.length());
        System.out.println("Correct Time Open : "+correctTimeOpen);
        System.out.println("Correct Time Close : "+correctTimeClose);
        /*
            Converting originals hours (strings to date)
        */
        
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        startHour = timeFormat.parse(debutHeure);
        endHour = timeFormat.parse(finHeure);
        placeStartHour = timeFormat.parse(correctTimeOpen);
        placeEndHour = timeFormat.parse(correctTimeClose);
        }
        if((placeStartHour.after(startHour))&& (placeEndHour.after(endHour))&&(price_level <= levelBudget)){
            return false;
        }else{
            return true;
        }
        
        }else{
            return true;
        }
        }else{
            return true;
        }
    }
    
    //méthode pour récupérer l'url d'un lieu
    public static String getUrlPlace(String placeId) throws MalformedURLException, IOException, JSONException{
        String HTTP_URL = "https://maps.googleapis.com/maps/api/place/details/json?placeid="+placeId+"&key="+GOOGLE_PLACE_DETAILS_API;
        URL url = new URL(HTTP_URL);
        String urlPlace = "";
        String html_output;
        try (Scanner scan = new Scanner(url.openStream())) {
            html_output = new String();
                while(scan.hasNext()){
                    html_output += scan.nextLine();
                }
        }
        JSONObject obj = new JSONObject(html_output);
        if(obj.has("result")){
            JSONObject result = obj.getJSONObject("result");
            urlPlace = result.getString("url");
        }
        
        return urlPlace;
    }
    
    public static int getLevelPriceBasedBudget(double budget){
        if(budget == 0){
            return 0;
        }else if(budget > 0 && budget <= 200){
            return 1;
        }else if(budget > 200 && budget <= 500){
            return 2;
        }else if(budget > 500 && budget <= 1000){
            return 3;
        }else {
            return 4;
        }
    }
}
