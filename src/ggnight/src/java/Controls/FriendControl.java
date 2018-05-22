













package Controls;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Functions.FriendFunctions;
import Models.Utilisateur;
import com.google.gson.Gson;
import javax.json.Json;

/**
 * Servlet implementation class FriendControl
 */
public class FriendControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String HiddenAddFriend = request.getParameter("HiddenAddFriend");
		String HiddenRejectFriendRequest = request.getParameter("HiddenRejectFriendRequest");
		String HiddenConfirmFriendRequest = request.getParameter("HiddenConfirmFriendRequest");
		String HiddenDeleteFriend = request.getParameter("HiddenDeleteFriend");
		String HiddenChercherAmi = request.getParameter("HiddenChercherAmi");
		if(HiddenAddFriend != null){
			boolean addFriend = false;
			String returnResult ="";
			int idFriend = Integer.parseInt(request.getParameter("idFriend"));
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			System.out.println("Les IDs sont : "+idFriend+" Et idUser : "+idUser);
			try {
				addFriend = FriendFunctions.AjouterAmi(idUser, idFriend);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(addFriend){
				returnResult = "Invitation envoyée";
			}else{
				returnResult = "Un probléme est apparu! refaire a nouveau!";
			}
			response.setContentType("text/plain");
			response.getWriter().write(returnResult);
		}
		
		if(HiddenRejectFriendRequest != null){
			//refuser une personne
			boolean confirmeReject = false;
			int ID_USER = Integer.parseInt(request.getParameter("idFriendSend"));
			int ID_FRIEND = Integer.parseInt(request.getParameter("idFriend"));
			try {
				confirmeReject = FriendFunctions.rejectRequestFriend(ID_USER,ID_FRIEND);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String returnResult = "";
			if(confirmeReject){
				returnResult = "Invitation annulée avec succées";
			}else{
				returnResult = "Une erreur est apparu ! refaire a nouveau!";
			}
			response.setContentType("text/plain");
			response.getWriter().write(returnResult);
			System.out.println("ID USER TO DELETE IS : "+ID_USER);
		}
		
		if(HiddenConfirmFriendRequest != null){
			//accepter une personne 
			boolean confirmeAccept = false;
			String returnResult = "";
			int ID_USER = Integer.parseInt(request.getParameter("idFriendSend"));
			int ID_FRIEND = Integer.parseInt(request.getParameter("idFriend"));
			try {
				confirmeAccept = FriendFunctions.acceptRequestFriend(ID_USER, ID_FRIEND);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(confirmeAccept){
				returnResult = "Demande d'ami acceptée";
			}else{
				returnResult = "Une érreur est apparue ! refaire a nouveau!";
			}
			response.setContentType("text/plain");
			response.getWriter().write(returnResult);
		}
		
		if(HiddenDeleteFriend != null){
			//supprimer un ami
			boolean deleteFriend = false;
			String returnResult = "";
			int idFriend = Integer.parseInt(request.getParameter("idFriend"));
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			try {
				deleteFriend = FriendFunctions.DeleteFriend(idUser, idFriend);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(deleteFriend){
				returnResult = "Suppréssion confirmée";
			}else{
				returnResult = "Une érreur est apparue ! refaire a nouveau!";
			}
			response.setContentType("text/plain");
			response.getWriter().write(returnResult);
		}
		
		if(HiddenChercherAmi != null){
			ArrayList<Utilisateur> searchFriend = null;
			String Nom = request.getParameter("nom");
			String Prenom = request.getParameter("prenom");
			try {
				searchFriend = FriendFunctions.friendSearchFind(Nom, Prenom);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String listToString = new Gson().toJson(searchFriend);
                        System.out.println("List ami chercher : "+listToString);
			response.setContentType("text/plain");
			response.getWriter().write(listToString);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
