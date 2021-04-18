package partie.plateau;

import java.io.Serializable;

import personnage.Personnage;

public class Plateau implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8950926030513685994L;
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
	
	
	public Integer calculDistance(Case previousCase, Integer ligne, Integer colonne) {
		return Math.abs(previousCase.getColonne() - colonne) + Math.abs(previousCase.getLigne() - ligne);
		
	}
	
	//Methodes
	public boolean isDansPlateau(Integer ligne, Integer colonne) {
		return (ligne >= 0 && ligne < NOMBRE_LIGNE) && (colonne >= 0 && colonne < NOMBRE_COLONNE ); 
	}
	
	public Case getCase(Integer ligne, Integer colonne) {
		if(isDansPlateau(ligne, colonne)) {
			return plateau[ligne][colonne];
		}else {
			return null;
		}
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
	
	public Integer placerPersonnage(Personnage personnage, Integer ligne, Integer colonne) {
		Integer distance = null;
		if(getCase(ligne, colonne) != null) {
			Case previousCase = getCase(personnage);
			if(previousCase != null) {
				previousCase.setPersonnage(null);
				distance = calculDistance(previousCase, ligne, colonne);
			}
			getCase(ligne, colonne).setPersonnage(personnage);
		}
		return distance;
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
	
	public String print() {
		String retour = "";
		for(Case[] ligne : this.plateau) {
			retour +="\n----------------------------------------------------------------------------------\n";
			retour += "|| ";
			for(Case c : ligne) {
				if(!c.isEmpty()) {
					retour += c.getPersonnage().getNom().charAt(0);
				}else {
					retour += " ";
				}
				retour += " || ";
			}
		}
		retour += "\n----------------------------------------------------------------------------------\n";
		return retour;
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
	
	public boolean peutDeplacer(Personnage personnage, Integer ligneFin, Integer colonneFin) {
		Integer deplacements = personnage.getDeplacementsAvecBonus();
		Case position = getCase(personnage);
		Integer distance =calculDistance(position, ligneFin, colonneFin);
		if(distance <= deplacements && getCase(ligneFin, colonneFin).getPersonnage() == null)
			return true;
		else {
			System.out.println("Déplacement impossible");
			return false;
		}
			

	}
	

	public boolean peutAttaquer(Personnage personnage, Integer ligneFin, Integer colonneFin) {
		Integer portee = personnage.getPorteeAvecBonus();
		Case position = getCase(personnage);
		Integer distance =calculDistance(position, ligneFin, colonneFin);
		if(distance <= portee && getCase(ligneFin, colonneFin).getPersonnage() != null)
			return true;
		else {
			return false;
		}

	}
}
