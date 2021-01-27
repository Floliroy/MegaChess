package personnage;

import personnage.origines.Ionia;

public abstract class Personnage {

	private String nom;

	public Personnage(String nom) {
		this.nom = nom;
	}
	
	public void getBonus() {
		if(this instanceof Ionia) {
			System.out.println("Bonus d'air");
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
