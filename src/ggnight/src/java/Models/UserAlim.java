package Models;

public class UserAlim {
	private int idUser,idAlimentation;
	public UserAlim(int idUser,int idAlimentation){
		this.idUser=idUser;
		this.idAlimentation=idAlimentation;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdAlimentation() {
		return idAlimentation;
	}
	public void setIdAlimentation(int idAlimentation) {
		this.idAlimentation = idAlimentation;
	}
	
}
