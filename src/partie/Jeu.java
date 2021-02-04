package partie;

import java.util.ArrayList;

public class Jeu {
	
	private static final Integer TAILLE_JOUEURS_MAX = 2;
	
	private ArrayList<Joueur> joueurs;
	
	public Jeu() {
		this.joueurs = new ArrayList<>();
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
