package personnage;

import java.io.Serializable;
import java.util.ArrayList;

import objet.typestat.Degats;
import objet.typestat.Deplacements;
import objet.typestat.Portee;
import objet.typestat.Vie;

public class Equipe extends ArrayList<Personnage> implements Serializable {

	private static final long serialVersionUID = -8065185716558859597L;
	
	public static final Integer TAILLE_EQUIPE_MAX = 2;
	
	private static final Integer BONUS_VIE = 50;
	private static final Integer BONUS_DEGATS = 10;
	private static final Integer BONUS_DEPLACEMENTS = 1;
	private static final Integer BONUS_PORTEE = 1;
	
	@Override
	public boolean add(Personnage personnage) {
		if(this.size() < TAILLE_EQUIPE_MAX && !this.contains(personnage)) {
			personnage.setEquipe(this);
			return super.add(personnage);
		}else {
			return false;
		}
	}
	
	public Personnage getPersonnageAvecNom(String nom) {
		for(Personnage personnage : this) {
			if(personnage.getNom().equals(nom)) {
				return personnage;
			}
		}
		return null;
	}
	
	
	private Integer getOrigineBonus(Personnage personnage, Class<?> typeStat, Integer bonus) {
		if(personnage.getOrigineTypeStat().equals(typeStat)) {
			Integer nombre = 0;
			for(Personnage perso : this) {
				if(perso.getOrigineTypeStat().equals(typeStat) && perso != personnage) {
					nombre++;
				}
			}
			return nombre * bonus;
		}
		return 0;
	}
	private Integer getElementBonus(Personnage personnage, Class<?> typeStat, Integer bonus) {
		if(personnage.getElementTypeStat().equals(typeStat)) {
			Integer nombre = 0;
			for(Personnage perso : this) {
				if(perso.getElementTypeStat().equals(typeStat) && perso != personnage) {
					nombre++;
				}
			}
			return nombre * bonus;
		}
		return 0;
	}
	private Integer getBonus(Personnage personnage, Class<?> typeStat, Integer bonus) {
		return this.getElementBonus(personnage, typeStat, bonus) + this.getOrigineBonus(personnage, typeStat, bonus);
	}

	public Integer getVieBonus(Personnage personnage) {	
		return this.getBonus(personnage, Vie.getTypeStat(), BONUS_VIE);
	}
	
	public Integer getDegatsBonus(Personnage personnage) {
		return this.getBonus(personnage, Degats.getTypeStat(), BONUS_DEGATS);
	}
	
	public Integer getDeplacementsBonus(Personnage personnage) {
		return this.getBonus(personnage, Deplacements.getTypeStat(), BONUS_DEPLACEMENTS);
	}
	
	public Integer getPorteeBonus(Personnage personnage) {
		return this.getBonus(personnage, Portee.getTypeStat(), BONUS_PORTEE);
	}

	public Boolean isComplete() {
		return this.size() == TAILLE_EQUIPE_MAX;
	}

	public Boolean isOneVivant() {
		for(Personnage personnage : this) {
			if(personnage.isVivant()) {
				return true;
			}
		}
		return false;
	}
	
	public void afficher() {
		for(Personnage personnage : this) {
			if(personnage.isVivant()) {
				System.out.println(personnage.getNom() + " (" + personnage.getNom().charAt(0) + ")");
			}
		}
	}
}
