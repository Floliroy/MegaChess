package partie;


import java.util.HashMap;

import serveur.base.Notification;


public class Jeu {
	
	private static final Integer TAILLE_JOUEURS_MAX = 2;
	
	private HashMap<String,Joueur> joueurs;
	
	public Jeu() {
		this.joueurs = new HashMap<String,Joueur>();
	}

	public void addJoueur(String nomJoueur, Joueur joueur) {
		if(!this.isComplet() && !this.joueurs.containsKey(nomJoueur)) {
			this.joueurs.put(nomJoueur, joueur);
			//System.out.println(nomJoueur + " a rejoint la partie");
		}
	}

	public boolean isComplet() {
		return joueurs.size() >= TAILLE_JOUEURS_MAX;
	}


}
