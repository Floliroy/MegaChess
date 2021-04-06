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
		for(int joueur=0 ; joueur<2 ; joueur++) {
			System.out.println("Entrez le nom du joueur " + joueur+1 + " :");
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
				
				Case c = joueur == 0 ? plateau.getFirstCaseLeft() : plateau.getFirstCaseRight();
				plateau.placerPersonnage(personnage, c.getLigne(), c.getColonne());
			}
		}
		System.out.println("Début de la Partie");
		
		Boolean partieFinie = false;
		Boolean joueur = false;
		do {
			joueur = !joueur;
			partieFinie = jouerTour(joueur ? 0 : 1);
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
				System.out.println(personnage.getNom() + " (" + personnage.getNom().charAt(0) + ") en position (" + plateau.getCase(personnage).getColonne() + ", " + plateau.getCase(personnage).getLigne() + ")");
			}
		}
		
		//On sélectionne ce que le joueur souhaite jouer
		System.out.println("Entre le nom du personnage que tu souhaites jouer :");
		Personnage personnage = joueur.getEquipe().getPersonnageAvecNom(Clavier.entrerClavierString());
		Integer deplacementsBase = personnage.getDeplacementsAvecBonus();
		boolean finTour = false;
		do {
			boolean peutDeplacer = deplacementsBase > 0;
			boolean peutAttaquer = joueur.isJetonAttaque();
			boolean peutPasser = joueur.isJetonPasser();
			Integer action = choixAction(peutDeplacer, peutAttaquer, peutPasser);
			if(action >= 3) {
				finTour = true;
			}else {
				if(peutDeplacer && action == 1) {
					Integer colonne;
					Integer ligne;
					do {
						System.out.println("Sur quelle case souhaitez vous aller ? (X, Y)");
						System.out.print("Entrer la colonne (X) :");
						colonne = Clavier.entrerClavierInt();
						System.out.print("Entrer la ligne (Y) :");
						ligne = Clavier.entrerClavierInt();
					}while(!plateau.isDansPlateau(ligne, colonne) || !plateau.peutDeplacer(personnage, ligne, colonne));
					plateau.placerPersonnage(personnage, ligne, colonne);
					joueur.setJetonPasser(true);
				}else if(peutAttaquer && ((action == 1 && !peutDeplacer) || (action == 2 && peutDeplacer))) {
					Personnage adversaire;
					do {
						System.out.println("Qui souhaitez vous attaquer ?");
						for(Personnage perso : joueurs.get((j+1)%2).getEquipe()) {
							if(personnage.isVivant()) {
								System.out.println(perso.getNom() + " (" + perso.getNom().charAt(0) + ") en position (" + plateau.getCase(perso).getColonne() + ", " + plateau.getCase(perso).getLigne() + ")");
							}
						}
						adversaire = joueurs.get((j+1)%2).getEquipe().getPersonnageAvecNom(Clavier.entrerClavierString());
					}while(!plateau.peutAttaquer(personnage, plateau.getCase(adversaire).getLigne(), plateau.getCase(adversaire).getColonne()));
					personnage.attaque(adversaire);
					if(!adversaire.isVivant()) {
						plateau.getCase(adversaire).setPersonnage(null);
					}
					joueur.setJetonPasser(true);
					joueur.setJetonAttaque(false);
				}else {
					finTour = true;
				}
			}
		}while(!finTour);
		joueur.resetJetons();
		
		return joueurs.get((j+1)%2).getEquipe().isOneVivant();
	}
	
	public Integer choixAction(boolean peutDeplacer, boolean peutAttaquer, boolean peutPasser) {
		Integer action;
		do {
			System.out.println("Choisis l'action que tu souhaites effectuer :");
			if(peutDeplacer) {
				System.out.println(" 1 - Se déplacer");
				if(peutAttaquer) {
					System.out.println(" 2 - Attaquer");
					if(peutPasser) {
						System.out.println(" 3 - Passer");
					}
				}else if(peutPasser) {
					System.out.println(" 2 - Passer");
				}
			}else if(peutAttaquer) {
				System.out.println(" 1 - Attaquer");
				if(peutPasser) {
					System.out.println(" 2 - Passer");
				}
			}else {
				return 3;
			}
			action = Clavier.entrerClavierInt();
		}while(action < 1|| action > 3);
		return action;
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
