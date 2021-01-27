package partie;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	
	private static final Integer TAILLE_JOUEURS_MAX = 2;
	
	private List<Joueur> joueurs;
	
	public Jeu() {
		this.joueurs = new ArrayList<>();
	}

	public void addJoueur(Joueur joueur) {
		this.joueurs.add(joueur);
	}

	public boolean isFull() {
		return joueurs.size() >= TAILLE_JOUEURS_MAX;
	}

}
