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
	
	public void placerPersonnage(Integer ligne, Integer colonne, Personnage p) {
		plateau[ligne][colonne].setPersonnage(p);
	}
	
}
