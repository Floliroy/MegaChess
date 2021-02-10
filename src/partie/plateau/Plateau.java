package partie.plateau;

import personnage.Personnage;

public class Plateau {

	
	private final static int NOMBRE_LIGNE = 8;
	private final static int NOMBRE_COLONNE = 16;
	
	private Case [][] plateau;
	
	// Constructeur
	public Plateau() {
		plateau = new Case[NOMBRE_LIGNE][NOMBRE_COLONNE];
		for(int lig = 0; lig < NOMBRE_LIGNE; lig ++) {
			for(int col = 0; col < NOMBRE_COLONNE; col ++)
				plateau[lig][col] = new Case(lig, col);
		}
	}
	
	
	//Methodes
	public boolean isDansPlateau(int ligne, int colonne) {
		return (ligne >= 0 && ligne < NOMBRE_LIGNE) && (colonne >= 0 && colonne < NOMBRE_COLONNE ); 
	}
	
	public Case getCase(int ligne, int colonne) {
		if(isDansPlateau(ligne, colonne))
			return plateau[ligne][colonne];
		else
			return null;
	}
	
	public void placerPersonnage(int ligne, int colonne, Personnage p) {
		plateau[ligne][colonne].setPersonnage(p);
	}
	
}
