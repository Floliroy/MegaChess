package partie.plateau;

import java.io.Serializable;

import personnage.Personnage;

public class Case implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3511835798078764807L;
	private Integer ligne;
	private Integer colonne;
	private Personnage personnage;
	
	// Constructeur
	public Case(Integer ligne, Integer colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}

	// Getters and Setters
	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	public Integer getLigne() {
		return ligne;
	}

	public Integer getColonne() {
		return colonne;
	}
	
	//Methodes
	public boolean isEmpty() {
		return personnage == null;
	}
	
	
}
