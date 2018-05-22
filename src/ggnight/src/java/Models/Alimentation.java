package Models;

public class Alimentation {
	private int idAlimentation;
	private String typeAlimentation;
	
	public Alimentation(int idAlimentation,String typeAlimentation){
		this.idAlimentation=idAlimentation;
		this.typeAlimentation=typeAlimentation;
	}

	public int getIdAlimentation() {
		return idAlimentation;
	}

	public void setIdAlimentation(int idAlimentation) {
		this.idAlimentation = idAlimentation;
	}

	public String getTypeAlimentation() {
		return typeAlimentation;
	}

	public void setTypeAlimentation(String typeAlimentation) {
		this.typeAlimentation = typeAlimentation;
	}
	
}
