package partie.plateau;

import personnage.Personnage;

public class Case {

	private int ligne;
	private int colonne;
	private Personnage personnage;
	
	// Constructeur
	public Case(int ligne, int colonne) {
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

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}
	
	//Methodes
	public boolean isEmpty() {
		return personnage == null;
	}
	
	
}
