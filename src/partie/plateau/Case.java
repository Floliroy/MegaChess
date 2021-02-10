package partie.plateau;

import personnage.Personnage;

public class Case {

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
