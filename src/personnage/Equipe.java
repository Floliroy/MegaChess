package personnage;

import java.util.ArrayList;

import objet.typestat.Degats;
import objet.typestat.Deplacements;
import objet.typestat.Portee;
import objet.typestat.Vie;

public class Equipe extends ArrayList<Personnage> {

	private static final long serialVersionUID = -8065185716558859597L;
	
	public static final Integer TAILLE_EQUIPE_MAX = 8;
	
	@Override
	public boolean add(Personnage personnage) {
		if(this.size() < TAILLE_EQUIPE_MAX && !this.contains(personnage)) {
			personnage.setEquipe(this);
			return super.add(personnage);
		}else {
			return false;
		}
	}

	public Integer getVieBonus(Personnage personnage) {
		Integer nombre = 0;
		Integer multiplier = 0;
		Integer bonus = 50;
		
		if(personnage instanceof Vie) {
			multiplier = (!(personnage instanceof Degats) && !(personnage instanceof Deplacements) && !(personnage instanceof Portee)) ? 2 : 1;
		}
		
		for(Personnage perso : this) {
			if(perso instanceof Vie && perso != personnage) {
				nombre++;
			}
		}
		
		return nombre * multiplier * bonus;
	}
	
	public Integer getDegatsBonus(Personnage personnage) {
		Integer nombre = 0;
		Integer multiplier = 0;
		Integer bonus = 10;
		
		if(personnage instanceof Degats) {
			multiplier = (!(personnage instanceof Vie) && !(personnage instanceof Deplacements) && !(personnage instanceof Portee)) ? 2 : 1;
		}
		
		for(Personnage perso : this) {
			if(perso instanceof Degats && perso != personnage) {
				nombre++;
			}
		}
		
		return nombre * multiplier * bonus;
	}
	
	public Integer getDeplacementsBonus(Personnage personnage) {
		Integer nombre = 0;
		Integer multiplier = 0;
		Integer bonus = 1;
		
		if(personnage instanceof Deplacements) {
			multiplier = (!(personnage instanceof Vie) && !(personnage instanceof Degats) && !(personnage instanceof Portee)) ? 2 : 1;
		}
		
		for(Personnage perso : this) {
			if(perso instanceof Deplacements && perso != personnage) {
				nombre++;
			}
		}
		
		return nombre * multiplier * bonus;
	}
	
	public Integer getPorteeBonus(Personnage personnage) {
		Integer nombre = 0;
		Integer multiplier = 0;
		Integer bonus = 1;
		
		if(personnage instanceof Portee) {
			multiplier = (!(personnage instanceof Vie) && !(personnage instanceof Degats) && !(personnage instanceof Deplacements)) ? 2 : 1;
		}
		
		for(Personnage perso : this) {
			if(perso instanceof Portee && perso != personnage) {
				nombre++;
			}
		}
		
		return nombre * multiplier * bonus;
	}

	public Boolean isComplete() {
		return this.size() == TAILLE_EQUIPE_MAX;
	}

}
