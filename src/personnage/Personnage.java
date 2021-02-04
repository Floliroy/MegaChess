package personnage;

import java.util.ArrayList;

import objet.Objet;
import objet.typestat.Degats;
import objet.typestat.Deplacements;
import objet.typestat.Portee;
import objet.typestat.Vie;
import personnage.elements.Element;
import personnage.origines.Origine;

public abstract class Personnage implements Element, Origine {

	public static final Integer TAILLE_INVENTAIRE_MAX = 3;
	
	private String nom;
	private Integer vie;
	private Integer vieBase;
	private Integer degats;
	private Integer deplacements;
	private Integer portee;
	private ArrayList<Objet> objets;
	
	private Equipe equipe;

	public Personnage(String nom, Integer vie, Integer degats, Integer deplacements, Integer portee) {
		this.nom = nom;
		this.vie = vie;
		this.vieBase = vie;
		this.degats = degats;
		this.deplacements = deplacements;
		this.portee = portee;
		this.setObjets(new ArrayList<>());
	}
	
	public Integer getVieAvecBonus() {
		Integer bonus = this.equipe.getVieBonus(this);
		for(Objet objet : objets) {
			if(objet instanceof Vie) {
				bonus += objet.getStat();
			}
		}
		return this.vie + bonus;
	}
	public Integer getVieBaseAvecBonus() {
		Integer bonus = this.equipe.getVieBonus(this);
		for(Objet objet : objets) {
			if(objet instanceof Vie) {
				bonus += objet.getStat();
			}
		}
		return this.vie + bonus;
	}
	public Integer getDegatsAvecBonus() {
		Integer bonus = this.equipe.getDegatsBonus(this);
		for(Objet objet : objets) {
			if(objet instanceof Degats) {
				bonus += objet.getStat();
			}
		}
		return this.degats + bonus;
	}
	public Integer getDeplacementsAvecBonus() {
		Integer bonus = this.equipe.getDeplacementsBonus(this);
		for(Objet objet : objets) {
			if(objet instanceof Deplacements) {
				bonus += objet.getStat();
			}
		}
		return this.deplacements + bonus;
	}
	public Integer getPorteeAvecBonus() {
		Integer bonus = this.equipe.getPorteeBonus(this);
		for(Objet objet : objets) {
			if(objet instanceof Portee) {
				bonus += objet.getStat();
			}
		}
		return this.portee + bonus;
	}

	public void recoitDegats(Integer degatsRecus) {
		degatsRecus = degatsRecus >= 0 ? degatsRecus : 0;
		vie -= degatsRecus;
		System.out.println(this.nom + " -" + degatsRecus + "PV");
	}
	
	public void attaque(Personnage adversaire) {
		adversaire.recoitDegats(getDegatsAvecBonus());
		System.out.println(this.nom + " attaque " + adversaire.getNom());
	}

	public Boolean isVivant() {
		return getVieAvecBonus() > 0;
	}
	
	public void addObjet(Objet objet) {
		if(this.objets.size() < TAILLE_INVENTAIRE_MAX) {
			this.objets.add(objet);
			System.out.println(this.nom + " recoit " + objet.getNom());
		}
	}
	
	/////////////////////////
	//// GETTER & SETTER ////
	/////////////////////////
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Integer getVie() {
		return vie;
	}

	public void setVie(Integer vie) {
		this.vie = vie;
	}

	public Integer getVieBase() {
		return vieBase;
	}

	public void setVieBase(Integer vieBase) {
		this.vieBase = vieBase;
	}

	public Integer getDegats() {
		return degats;
	}

	public void setDegats(Integer degats) {
		this.degats = degats;
	}

	public Integer getDeplacements() {
		return deplacements;
	}

	public void setDeplacements(Integer deplacements) {
		this.deplacements = deplacements;
	}

	public Integer getPortee() {
		return portee;
	}

	public void setPortee(Integer portee) {
		this.portee = portee;
	}

	public ArrayList<Objet> getObjets() {
		return objets;
	}

	public void setObjets(ArrayList<Objet> objets) {
		this.objets = objets;
	}
	
}
