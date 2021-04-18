package test;

import partie.plateau.Plateau;
import personnage.Equipe;
import personnage.personnages.Ahri;
import personnage.personnages.Fizz;

public class Test {

	public static void main(String[] args) {
		Equipe equipe1 = new Equipe();
		Equipe equipe2 = new Equipe();
		
		Ahri ahri = new Ahri();
		equipe1.add(ahri);
		Fizz fizz = new Fizz();
		equipe2.add(fizz);

		Plateau plateau = new Plateau();
		plateau.placerPersonnage(ahri, 3, 2);
		plateau.placerPersonnage(fizz, 5, 6);
		plateau.afficher();
	}

}
