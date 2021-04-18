package partie;

import java.io.Serializable;

import personnage.Equipe;

public class Joueur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2760203883913530088L;

	private String nom;
	
	private Equipe equipe;
	
	private boolean jetonAttaque;
	private boolean jetonPasser;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.equipe = new Equipe();
		this.resetJetons();
	}
	
	public void resetJetons() {
		this.jetonAttaque = true;
		this.jetonPasser = false;
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

	public boolean isJetonAttaque() {
		return jetonAttaque;
	}

	public void setJetonAttaque(boolean jetonAttaque) {
		this.jetonAttaque = jetonAttaque;
	}

	public boolean isJetonPasser() {
		return jetonPasser;
	}

	public void setJetonPasser(boolean jetonPasser) {
		this.jetonPasser = jetonPasser;
	}

}
