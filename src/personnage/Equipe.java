package personnage;

import java.util.ArrayList;

import objet.typestat.Degats;
import objet.typestat.Deplacements;
import objet.typestat.Portee;
import objet.typestat.Vie;

public class Equipe extends ArrayList<Personnage> {

	private static final long serialVersionUID = -8065185716558859597L;
	
	public static final Integer TAILLE_EQUIPE_MAX = 8;
	
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
	
	private Integer getOrigineBonus(Personnage personnage, Class<?> typeStat, Integer bonus) {
		if(personnage.getOrigineTypeStat().equals(typeStat)) {
			Integer nombre = 1;
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
			Integer nombre = 1;
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

}
