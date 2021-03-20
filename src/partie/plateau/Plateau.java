package partie.plateau;

import personnage.Personnage;

public class Plateau {

	
	private final static Integer NOMBRE_LIGNE = 8;
	private final static Integer NOMBRE_COLONNE = 16;
	
	private Case [][] plateau;
	
	// Constructeur
	public Plateau() {
		plateau = new Case[NOMBRE_LIGNE][NOMBRE_COLONNE];
		for(Integer lig = 0; lig < NOMBRE_LIGNE; lig ++) {
			for(Integer col = 0; col < NOMBRE_COLONNE; col ++)
				plateau[lig][col] = new Case(lig, col);
		}
	}
	
	
	//Methodes
	public boolean isDansPlateau(Integer ligne, Integer colonne) {
		return (ligne >= 0 && ligne < NOMBRE_LIGNE) && (colonne >= 0 && colonne < NOMBRE_COLONNE ); 
	}
	
	public Case getCase(Integer ligne, Integer colonne) {
		if(isDansPlateau(ligne, colonne))
			return plateau[ligne][colonne];
		else
			return null;
	}
	
	public Case getCase(Personnage personnage){
		for(Case[] ligne : plateau) {
			for(Case c : ligne) {
				if(!c.isEmpty() && c.getPersonnage().equals(personnage))
					return c;
			}
		}
		return null;
	}
	
	public void placerPersonnage(Personnage personnage, Integer ligne, Integer colonne) {
		if(getCase(ligne, colonne) == null) {
			plateau[ligne][colonne].setPersonnage(personnage);
		}
	}
	
	public void afficher() {
		for(Case[] ligne : this.plateau) {
			System.out.print("\n----------------------------------------------------------------------------------\n");
			System.out.print("|| ");
			for(Case c : ligne) {
				if(!c.isEmpty()) {
					System.out.print(c.getPersonnage().getNom().charAt(0));
				}else {
					System.out.print(" ");
				}
				System.out.print(" || ");
			}
		}
		System.out.print("\n----------------------------------------------------------------------------------\n");
	}
	
	public Case getFirstCaseLeft() {
		for(Case []ligne : plateau) {
			for(Case c : ligne) {
				//On regarde si la colonne est bien l'une des 4 premieres
				if(c.getColonne() < 4 && c.isEmpty()) {
					return c;
				}
			}
		}
		return null;
	}
	
	public Case getFirstCaseRight() {
		for(Case[] ligne : plateau) {
			for(Case c : ligne) {
				//On regarde si la colonne est bien l'une des 4 dernieres
				if(c.getColonne() >= Plateau.NOMBRE_COLONNE-4 && c.isEmpty()) {
					return c;
				}
			}
		}
		return null;
	}
}
