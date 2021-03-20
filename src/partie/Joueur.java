package partie;

import personnage.Equipe;

public class Joueur {

	private String nom;
	
	private Equipe equipe;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.equipe = new Equipe();
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

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

}
