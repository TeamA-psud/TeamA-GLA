package Controls;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import Functions.GeoLocationFunction;
import Functions.InviteFunction;
import Functions.LieuFunction;
import Functions.PlaceAPIFunction;
import Functions.SoireeFunction;
import Functions.UserFunctions;
import Models.GeoLocation;
import Models.Lieu;
import Models.Place;
import Models.Soiree;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class EventControl
 */
public class EventControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private static final Charset UTF_8 = Charset.forName("UTF-8");
        private static final Charset ISO = Charset.forName("ISO-8859-1");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        String date="";String time="";String timeEnd="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                System.out.println("EventControl Servlet Start");
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		String [] idFriends = request.getParameterValues("friends");
                System.out.println("Table ids friends is : "+Arrays.toString(idFriends));
                String stringIdsFriends = Arrays.toString(idFriends);
                System.out.println("Table toString : "+stringIdsFriends);
                ArrayList<Integer> allIdsFriends = new ArrayList<Integer>();
                allIdsFriends.add(idUser);
            for (String idFriend : idFriends) {
                allIdsFriends.add(Integer.parseInt(idFriend));
            }
                System.out.println("Integer IDs user and friend are : "+allIdsFriends.toString());
		date = request.getParameter("date");
		time = request.getParameter("time");
                timeEnd = request.getParameter("timeEnd");
                /*
                    Converted string date entred into date object
                */
                Date dateEntred = null;
                Date timeEntred = null;
                Date timeNow = null;
                String todayDate;
                String getTimeNow;
                Date finalTodayDate = null;
                Date getTodayDate = new Date();
                DateFormat foramt = new SimpleDateFormat("yyyy-MM-dd");
                DateFormat timesFormat = new SimpleDateFormat("HH:mm");
                try{
                    dateEntred = foramt.parse(date);// D
                    todayDate = foramt.format(getTodayDate);
                    finalTodayDate = foramt.parse(todayDate); // D
                    
                    //Times
                    timeEntred = timesFormat.parse(time); //T
                    getTimeNow = timesFormat.format(getTodayDate);
                    timeNow = timesFormat.parse(getTimeNow); //T
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                if(dateEntred.before(finalTodayDate)){
                    //show error page
                    response.sendRedirect("http://localhost:8080/ggnight/acceuil/errorDate.jsp");
                    System.out.println("La date entrée est inférieur a la date d'aujourd'hui");
                }
                if(dateEntred.equals(finalTodayDate)){
                    //date entred equal to today's date
                    //we have to compare the hours now
                    if(timeEntred.before(timeNow) || (timeEntred.equals(timeNow))){
                        //error
                        response.sendRedirect("http://localhost:8080/ggnight/acceuil/errorTime.jsp");
                        System.out.println("Vous avez entrée une heure non valide");
                    }
                }
                if(dateEntred.after(finalTodayDate)){
                    //date& hour okey // go for showing places //
                    request.setAttribute("ids",allIdsFriends);
                    request.setAttribute("date",date);
                    request.setAttribute("time",time);
                    request.setAttribute("timeEnd",timeEnd);
                    System.out.println("IDs users after setAttribute are : "+allIdsFriends.toString());
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/acceuil/showPlaces.jsp");
                    rd.forward(request, response);
                    //response.sendRedirect("http://localhost:8080/ggnight/acceuil/showPlaces.jsp");
                }
                System.out.println("the date is : "+date);
                System.out.println("The time is : "+time);
                
                
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                String HiddenConfirmAddEvent = request.getParameter("HiddenConfirmAddEvent");
                String HiddenDeleteEvent = request.getParameter("HiddenDeleteEvent");
                String HiddenConfirmeEvent = request.getParameter("HiddenConfirmeEvent");
                String HiddenRejectEvent = request.getParameter("HiddenRejectEvent");
                if(HiddenConfirmAddEvent != null){
                    //reserver un lieu
                    String returnResult = "";
                    int executeAddLieu = 0;
                    int executeAddSoiree =0;
                    boolean executeSendNotification = false;
                    String nom = request.getParameter("nom");
                    String completeName = new String(nom.getBytes(ISO),UTF_8);
                    String adresse = request.getParameter("adresse");
                    String completeAdresse = new String(adresse.getBytes(ISO),UTF_8);
                    double rating = Double.parseDouble(request.getParameter("rating"));
                    String placeId = request.getParameter("placeId");
                    String idPersons = request.getParameter("idPersons");
                    if(idPersons.equalsIgnoreCase("[]")){
                        response.sendRedirect("http://localhost:8080/ggnight/acceuil/errorInvite.jsp");
                    }else{
                    String PersonId = idPersons.replaceAll("\\[","").replaceAll("\\]","").replace(" ","");
                    System.out.println("Id persons are : "+PersonId);
                    ArrayList<String> idString = new ArrayList<String>(Arrays.asList(PersonId.split(",")));
                    System.out.println("idString in arrayList : "+idString.toString());
                    ArrayList<Integer> IdPersonInt = new ArrayList<Integer>();
                    for(int i=0 ; i<idString.size();i++){
                        IdPersonInt.add(Integer.parseInt(idString.get(i)));
                    }
                    Lieu lieu = new Lieu(completeName,completeAdresse, placeId, rating);
                    try {
                        executeAddLieu = LieuFunction.AjouterLieu(lieu);
                    } catch (SQLException ex) {
                        Logger.getLogger(EventControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(executeAddLieu != -1){
                        //méthode ajouter lieu est éffectuer avec succées
                        //ajouter la soirée avec notifications
                        int idOrganisateur = IdPersonInt.get(0);
                        Soiree soiree = new Soiree(idOrganisateur, executeAddLieu, date,time,timeEnd);
                        try {
                            executeAddSoiree = SoireeFunction.AjouterSoiree(soiree);
                        } catch (SQLException ex) {
                            Logger.getLogger(EventControl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(executeAddSoiree != -1){
                            try {
                                //méthode ajouter soirée est éffectuer avec succées
                                //inviter les amis
                                executeSendNotification = InviteFunction.SendNotificationEvent(IdPersonInt, executeAddSoiree);
                            } catch (SQLException ex) {
                                Logger.getLogger(EventControl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if(executeSendNotification){
                                returnResult="0";
                            }else{
                                returnResult = "-3";
                            }
                        }else{
                            returnResult="-2";
                        }
                    }else{
                        returnResult = "-1";
                    }
                    System.out.println("le nom est: "+nom);
                    System.out.println("l'adresse est: "+adresse);
                    System.out.println("le rating est: "+rating);
                    System.out.println("placeId est: "+placeId);
                    System.out.println("organisateur est invités est: "+idPersons);
                    
                    response.setContentType("application/text");
                    response.getWriter().write(returnResult);
                    
                    }
                }
                
                if(HiddenDeleteEvent != null){
                    String returnResult = "";
                    boolean confirmeDeleteInvitation = false;
                    boolean confirmeDeleteSoiree = false;
                    boolean confirmeDeleteLieu = false;
                    int idLieu = Integer.parseInt(request.getParameter("idLieu"));
                    int idOrganisateur = Integer.parseInt(request.getParameter("idSoiree"));
                    int idSoiree = Integer.parseInt(request.getParameter("idOrganisateur"));
                    try {
                        confirmeDeleteInvitation = InviteFunction.deleteInvitation(idOrganisateur);
                    } catch (SQLException ex) {
                        Logger.getLogger(EventControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(confirmeDeleteInvitation){
                        try {
                            confirmeDeleteSoiree = SoireeFunction.deleteSoiree(idSoiree);
                            if(confirmeDeleteSoiree){
                                confirmeDeleteLieu = LieuFunction.deletePlace(idLieu);
                                if(confirmeDeleteLieu){
                                    returnResult = "0";
                                }else{
                                    returnResult = "-3";
                                }
                            }else{
                                returnResult = "-2";
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(EventControl.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        returnResult = "-1";
                    }
                    response.setContentType("application/text");
                    response.getWriter().write(returnResult);
                }
                
                
                if(HiddenConfirmeEvent != null){
                    //l'utilisateur confirme la participation a la soirrée
                    boolean confirmeEvent = false;
                    String returnResult = "";
                    int idUser = Integer.parseInt(request.getParameter("idUser"));
                    try {
                        confirmeEvent = InviteFunction.confirmeEvent(idUser);
                    } catch (SQLException ex) {
                        Logger.getLogger(EventControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(confirmeEvent){
                        returnResult = "1";
                    }else{
                        returnResult = "0";
                    }
                    response.setContentType("application/text");
                    response.getWriter().write(returnResult);
                }
                
                if(HiddenRejectEvent != null){
                    //l'utilisateur ne participe pas a la soirée
                    boolean rejectEvent = false;
                    String returnResult = "";
                    int idUser = Integer.parseInt(request.getParameter("idUser"));
                    try {
                        rejectEvent = InviteFunction.rejectEvent(idUser);
                    } catch (SQLException ex) {
                        Logger.getLogger(EventControl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(rejectEvent){
                        returnResult = "1";
                    }else{
                        returnResult = "0";
                    }
                    response.setContentType("application/text");
                    response.getWriter().write(returnResult);
                }
	}

}
