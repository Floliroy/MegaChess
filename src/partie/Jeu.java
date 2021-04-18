package partie;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import partie.plateau.Case;
import partie.plateau.Plateau;
import personnage.Equipe;
import personnage.Personnage;
import serveur.base.GameManager;
import util.Clavier;
import util.Util;

public class Jeu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Integer TAILLE_JOUEURS_MAX = 2;
	
	private ArrayList<Joueur> joueurs;
	private Plateau plateau;
	
	public Jeu() {
		this.joueurs = new ArrayList<>();
		this.plateau = new Plateau();
	}

	public void creerEquipe(GameManager manager, Boolean createurPartie) throws RemoteException {
		Integer joueur = createurPartie ? 0 : 1;
		for(int i=0 ; i<Equipe.TAILLE_EQUIPE_MAX ; i++) {
			Personnage personnage;
			do {
				System.out.println(joueurs.get(joueur).getNom() + " entre le nom du personnage que tu souhaites ajouter a ton équipe :");
				personnage = Util.getPersonnageAvecNom(Clavier.entrerClavierString());
				if(personnage != null) {
					personnage = joueurs.get(joueur).getEquipe().getPersonnageAvecNom(personnage.getNom()) != null ? null : personnage;
				}
			}while(personnage == null);
			
			joueurs.get(joueur).getEquipe().add(personnage);
		}
		manager.creerEquipe(joueurs.get(joueur).getEquipe(), createurPartie);
	}	
	
	public Boolean jouerTour(GameManager manager, Boolean createurPartie) throws RemoteException {
		Integer j = createurPartie ? 0 : 1;
		plateau.afficher();
		//On affiche les infos du joueur
		Joueur joueur = joueurs.get(j);
		if(!joueur.getEquipe().isOneVivant()) {
			return true;
		}
		System.out.println("\n" + joueur.getNom() + " a ton tour !\n");
		System.out.println("Tu possèdes les pions :");
		for(Personnage personnage : joueur.getEquipe()) {
			if(personnage.isVivant()) {
				System.out.println(personnage.getNom() + " (" + personnage.getNom().charAt(0) + ") en position (" + plateau.getCase(personnage).getColonne() + ", " + plateau.getCase(personnage).getLigne() + ")");
			}
		}
		
		//On sélectionne ce que le joueur souhaite jouer
		Personnage personnage = null;
		do {
			System.out.println("Entre le nom du personnage que tu souhaites jouer :");
			personnage = Util.getPersonnageAvecNom(Clavier.entrerClavierString());
			if(personnage == null) {
				System.out.println("Saisie incorrecte");
			} else {
				personnage = joueur.getEquipe().getPersonnageAvecNom(personnage.getNom());
			}
		}while(personnage == null);
		
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
						System.out.println("\nVous avez " + deplacementsBase + " de deplacements disponible !");
						System.out.println("Sur quelle case souhaitez vous aller ? (X, Y)");
						System.out.print("Entrer la colonne (X) : ");
						colonne = Clavier.entrerClavierInt();
						System.out.print("Entrer la ligne (Y) : ");
						ligne = Clavier.entrerClavierInt();
					}while(!plateau.isDansPlateau(ligne, colonne) || !plateau.peutDeplacer(personnage, ligne, colonne));
					
					Case prevCase = plateau.getCase(personnage);
					Integer distance = plateau.placerPersonnage(personnage, ligne, colonne);
					deplacementsBase -= distance;
					
					manager.deplacerPersonnage(prevCase, ligne, colonne);
					joueur.setJetonPasser(true);
				}else if(peutAttaquer && ((action == 1 && !peutDeplacer) || (action == 2 && peutDeplacer))) {
					Personnage adversaire = null;
					
					do {
						System.out.println("\nQui souhaitez vous attaquer ?");
						Boolean cibleDispo = false;
						for(Personnage perso : joueurs.get((j+1)%2).getEquipe()) {
							if(perso.isVivant() && plateau.peutAttaquer(personnage, plateau.getCase(perso).getLigne(), plateau.getCase(perso).getColonne())) {
								cibleDispo = true;
								System.out.println(perso.getNom() + " (" + perso.getNom().charAt(0) + ") en position (" + plateau.getCase(perso).getColonne() + ", " + plateau.getCase(perso).getLigne() + ")");
							}
						}
						if(!cibleDispo) {
							System.out.println("Pas de cible attaquable");
						} else {
							adversaire = joueurs.get((j+1)%2).getEquipe().getPersonnageAvecNom(Clavier.entrerClavierString());
						}
							
					}while(adversaire != null && !plateau.peutAttaquer(personnage, plateau.getCase(adversaire).getLigne(), plateau.getCase(adversaire).getColonne()));
					
					if(adversaire != null) {
						Case prevCase = plateau.getCase(adversaire);
						personnage.attaque(adversaire, null);
						if(!adversaire.isVivant()) {
							prevCase.setPersonnage(null);
						}
						
						manager.subitDegats(prevCase, personnage);
						
						joueur.setJetonPasser(true);
						joueur.setJetonAttaque(false);
					}
					
				}else {
					finTour = true;
				}
			}
		}while(!finTour);
		joueur.resetJetons();
		
		return !joueurs.get((j+1)%2).getEquipe().isOneVivant();
	}
	
	public Integer choixAction(boolean peutDeplacer, boolean peutAttaquer, boolean peutPasser) {
		Integer action;
		do {
			System.out.println("\nChoisis l'action que tu souhaites effectuer :");
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
	
	public boolean bothEquipeComplete() {
		if(!isComplet()) return false;
		
		for(Joueur joueur : joueurs) {
			if(!joueur.getEquipe().isComplete()) {
				return false;
			}
		}
		return true;
	}
	
	public Plateau getPlateau() {
		return this.plateau;
	}
	
	public ArrayList<Joueur> getJoueurs() {
		return this.joueurs;
	}

}
