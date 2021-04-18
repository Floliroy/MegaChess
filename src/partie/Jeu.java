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
	/**
	 * Fonction qui permet de créer une équipe en ajoutant des personnages
	 */
	public void creerEquipe(GameManager manager, Boolean createurPartie) throws RemoteException {
		Integer joueur = createurPartie ? 0 : 1;
		//On vérifie que l'équipe n'est pas remplie
		for(int i=0 ; i<Equipe.TAILLE_EQUIPE_MAX ; i++) {
			Personnage personnage;
			do {
				//On entre le nom du personnage que l'on veut dans l'équipe
				System.out.println(joueurs.get(joueur).getNom() + " entre le nom du personnage que tu souhaites ajouter a ton équipe :");
				personnage = Util.getPersonnageAvecNom(Clavier.entrerClavierString());
				//On verifie si le personnage existe bien
				if(personnage != null) {
					personnage = joueurs.get(joueur).getEquipe().getPersonnageAvecNom(personnage.getNom()) != null ? null : personnage;
				}
			}while(personnage == null);
			//On ajoute le personnage choisi
			joueurs.get(joueur).getEquipe().add(personnage);
		}
		manager.creerEquipe(joueurs.get(joueur).getEquipe(), createurPartie);
	}	
	/**
	 * Fonction qui permet de jouer un tour
	 */
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
		//On affiche les personnages vivants avec leurs positions sur le plateau
		for(Personnage personnage : joueur.getEquipe()) {
			if(personnage.isVivant()) {
				System.out.println(personnage.getNom() + " (" + personnage.getNom().charAt(0) + ") en position (" + plateau.getCase(personnage).getColonne() + ", " + plateau.getCase(personnage).getLigne() + ")");
			}
		}
		
		//On entre le nom du personnage que l'on souhaite utiliser
		Personnage personnage = null;
		do {
			System.out.println("Entre le nom du personnage que tu souhaites jouer :");
			personnage = Util.getPersonnageAvecNom(Clavier.entrerClavierString());
			//On vérifie qu'il existe
			if(personnage == null) {
				System.out.println("Saisie incorrecte");
			} else {
				personnage = joueur.getEquipe().getPersonnageAvecNom(personnage.getNom());
			}
		}while(personnage == null);
		
		//On choisit l'action que l'on veut réaliser avec le personnage
		Integer deplacementsBase = personnage.getDeplacementsAvecBonus();
		boolean finTour = false;
		do {
			boolean peutDeplacer = deplacementsBase > 0;
			boolean peutAttaquer = joueur.isJetonAttaque();
			boolean peutPasser = joueur.isJetonPasser();
			Integer action = choixAction(peutDeplacer, peutAttaquer, peutPasser);
			//Si le choix de l'action est peutPasser alors on passe son tour
			if(action >= 3) {
				finTour = true;
			}else {
				//Si le choix est peutDeplacer
				if(peutDeplacer && action == 1) {
					Integer colonne;
					Integer ligne;
					do {
						//On donne la distance de déplacement possible
						System.out.println("\nVous avez " + deplacementsBase + " de deplacements disponible !");
						System.out.println("Sur quelle case souhaitez vous aller ? (X, Y)");
						//Le joueur choisit la colonne et la ligne où il veut déplacer le personnage
						System.out.print("Entrer la colonne (X) : ");
						colonne = Clavier.entrerClavierInt();
						System.out.print("Entrer la ligne (Y) : ");
						ligne = Clavier.entrerClavierInt();
					//On vérifie si le personnage à le nombre de déplacement nécessaire
					}while(!plateau.isDansPlateau(ligne, colonne) || !plateau.peutDeplacer(personnage, ligne, colonne));
					//On deplace alors le personnage à cette nouvelle position
					Case prevCase = plateau.getCase(personnage);
					Integer distance = plateau.placerPersonnage(personnage, ligne, colonne);
					deplacementsBase -= distance;
					
					manager.deplacerPersonnage(prevCase, ligne, colonne);
					joueur.setJetonPasser(true);
				//Si le choix est peutAttaquer
				}else if(peutAttaquer && ((action == 1 && !peutDeplacer) || (action == 2 && peutDeplacer))) {
					Personnage adversaire = null;
					
					do {
						//On demande quel personnage le joueur veut attaquer avec son personnage
						System.out.println("\nQui souhaitez vous attaquer ?");
						Boolean cibleDispo = false;
						//On lui affiche la liste des personnages attaquables
						for(Personnage perso : joueurs.get((j+1)%2).getEquipe()) {
							if(perso.isVivant() && plateau.peutAttaquer(personnage, plateau.getCase(perso).getLigne(), plateau.getCase(perso).getColonne())) {
								cibleDispo = true;
								System.out.println(perso.getNom() + " (" + perso.getNom().charAt(0) + ") en position (" + plateau.getCase(perso).getColonne() + ", " + plateau.getCase(perso).getLigne() + ")");
							}
						}
						//S'il n'y a pas de personnage attaquable
						if(!cibleDispo) {
							System.out.println("Pas de cible attaquable");
						//Le joueur choisit le personnage à attaquer
						} else {
							adversaire = joueurs.get((j+1)%2).getEquipe().getPersonnageAvecNom(Clavier.entrerClavierString());
						}
					//Traitement de l'attaque	
					}while(adversaire != null && !plateau.peutAttaquer(personnage, plateau.getCase(adversaire).getLigne(), plateau.getCase(adversaire).getColonne()));
					
					if(adversaire != null) {
						//Le personnage attaque son adversaire
						Case prevCase = plateau.getCase(adversaire);
						personnage.attaque(adversaire, null);
						//Verification si l'adversaire est toujours vivant
						if(!adversaire.isVivant()) {
							prevCase.setPersonnage(null);
						}
						//Notre personnage subit des dégats
						manager.subitDegats(prevCase, personnage);
						
						//Les jetons d'action sont actualisés 
						joueur.setJetonPasser(true);
						joueur.setJetonAttaque(false);
					}
					
				}else {
					finTour = true;
				}
			}
		}while(!finTour);
		// On reset les jetons pour le prochain tour
		joueur.resetJetons();
		
		return !joueurs.get((j+1)%2).getEquipe().isOneVivant();
	}
	
	/**
	 * Fonction qui permet au joueur de choisir l'action qui veut réaliser
	 */
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
	
	/**
	 * Fonction qui ajoute un joueur
	 * - verifie si le jeu n'est pas déjà complet
	 * - ajoute le joueur
	 */
	public void addJoueur(Joueur joueur) {
		if(!this.isComplet() && !this.joueurs.contains(joueur)) {
			this.joueurs.add(joueur);
		}
	}
	/**
	 * Fonction qui permet de verifier si le jeu est complet
	 * - on retourne un booléen si la taille est supérieure ou égal au maximum de joueurs possibles
	 */
	public boolean isComplet() {
		return joueurs.size() >= TAILLE_JOUEURS_MAX;
	}
	
	/**
	 * Fonction qui permet de verifier si les équipes des deux joueurs sont complètes
	 * - pour les différents joueurs on utilise la méthode isComplete pour vérifier si les équipes sont bien totalement remplies
	 * - si ce n'est pas le cas alors on retourne faux
	 * - sinon on retourne vrai
	 */
	public boolean bothEquipeComplete() {
		if(!isComplet()) return false;
		
		for(Joueur joueur : joueurs) {
			if(!joueur.getEquipe().isComplete()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Fonction qui récupère le plateau
	 *
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}
	/**
	 * Fonction qui récupère la liste des joueurs
	 *
	 */
	public ArrayList<Joueur> getJoueurs() {
		return this.joueurs;
	}

}
