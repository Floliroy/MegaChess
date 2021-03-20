package partie;

import java.util.ArrayList;

import partie.plateau.Case;
import partie.plateau.Plateau;
import personnage.Equipe;
import personnage.Personnage;
import util.Clavier;
import util.Util;

public class Jeu {
	
	private static final Integer TAILLE_JOUEURS_MAX = 2;
	
	private ArrayList<Joueur> joueurs;
	private Plateau plateau;
	
	public Jeu() {
		this.joueurs = new ArrayList<>();
	}
	
	public void lancerPartie() {
		for(int joueur=1 ; joueur<=2 ; joueur++) {
			System.out.println("Entrez le nom du joueur " + joueur + " :");
			joueurs.add(new Joueur(Clavier.entrerClavierString()));
			
			for(int i=0 ; i<Equipe.TAILLE_EQUIPE_MAX ; i++) {
				Personnage personnage;
				do {
					System.out.println(joueurs.get(joueur).getNom() + " entre le nom du personnage que tu souhaites ajouter a ton équipe :");
					personnage = Util.getPersonnageAvecNom(Clavier.entrerClavierString());
					if(personnage != null) {
						personnage = joueurs.get(joueur).getEquipe().contains(personnage) ? null : personnage;
					}
				}while(personnage == null);
				
				joueurs.get(joueur).getEquipe().add(personnage);
				
				Case c = joueur == 1 ? plateau.getFirstCaseLeft() : plateau.getFirstCaseRight();
				plateau.placerPersonnage(personnage, c.getLigne(), c.getColonne());
			}
		}
		System.out.println("Début de la Partie");
		
		Boolean partieFinie = false;
		Boolean joueur = false;
		do {
			joueur = !joueur;
			partieFinie = jouerTour(joueur ? 1 : 2);
		}while(!partieFinie);
	}

	public Boolean jouerTour(Integer j) {
		plateau.afficher();
		//On affiche les infos du joueur
		Joueur joueur = joueurs.get(j);
		System.out.println(joueur.getNom() + " a ton tour !");
		System.out.println("Tu possèdes les pions :");
		for(Personnage personnage : joueur.getEquipe()) {
			if(personnage.isVivant()) {
				System.out.println(personnage.getNom() + " (" + personnage.getNom().charAt(0) + ") en position (" + plateau.getCase(personnage).getColonne() + ", " + plateau.getCase(personnage).getColonne() + ")");
			}
		}
		
		//On sélectionne ce que le joueur souhaite jouer
		System.out.println("Entre le nom du personnage que tu souhaites jouer :");
		Personnage personnage = Util.getPersonnageAvecNom(Clavier.entrerClavierString(), joueur.getEquipe());
		
		
		return false;
	}
	
	public void addJoueur(Joueur joueur) {
		if(!this.isComplet() && !this.joueurs.contains(joueur)) {
			this.joueurs.add(joueur);
		}
	}

	public boolean isComplet() {
		return joueurs.size() >= TAILLE_JOUEURS_MAX;
	}

}
