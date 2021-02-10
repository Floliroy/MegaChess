package objet;

public abstract class Objet {

	private Integer stat;
	private String nom;
	

	public Objet(String nom, Integer stat) {
		this.stat = stat;
		this.nom = nom;
	}
	
	/////////////////////////
	//// GETTER & SETTER ////
	/////////////////////////
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Integer getStat() {
		return stat;
	}
	
	public void setStat(Integer stat) {
		this.stat = stat;
	}
}