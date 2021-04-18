package personnage;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import objet.Objet;
import objet.typestat.Degats;
import objet.typestat.Deplacements;
import objet.typestat.Portee;
import objet.typestat.Vie;
import objet.typestat.Vitesse;
import personnage.elements.Element;
import personnage.origines.Origine;
import serveur.base.GameManager;
import serveur.base.MessageNotification;

public abstract class Personnage implements Element, Origine, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6874285791013628216L;

	////////////////////
	//// CONSTANTES ////
	////////////////////
	public static final Integer TAILLE_INVENTAIRE_MAX = 3;

	//////////////////
	//// ATRIBUTS ////
	//////////////////
	private String nom;
	private Integer vie;
	private Integer vieBase;
	private Integer degats;
	private Integer deplacements;
	private Integer portee;
	private Double esquive;
	private Double vitesse;
	private ArrayList<Objet> objets;
	
	private Equipe equipe;

	public Personnage(String nom, Integer vie, Integer degats, Integer deplacements, Integer portee, Double vitesse) {
		this.nom = nom;
		this.vie = vie;
		this.vieBase = vie;
		this.degats = degats;
		this.deplacements = deplacements;
		this.portee = portee;
		this.esquive = 0.1;
		this.vitesse = vitesse;
		this.objets = new ArrayList<>();
	}

	//////////////////
	//// MÉTHODES ////
	//////////////////
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
	public Double getVitesseAvecBonus() {
		Integer bonus = 0;
		for(Objet objet : objets) {
			if(objet instanceof Vitesse) {
				bonus += objet.getStat();
			}
		}
		return this.vitesse + bonus/100;
	}
	public Double getEsquiveAvecBonus() {
		Integer bonus = 0;
		for(Objet objet : objets) {
			if(objet instanceof Vitesse) {
				bonus += objet.getStat();
			}
		}
		return this.esquive + bonus/100;
	}
	
	public void recoitDegats(Integer degatsRecus, GameManager manager) throws RemoteException {
		degatsRecus = degatsRecus >= 0 ? degatsRecus : 0;
		if(Math.random() > this.getEsquiveAvecBonus()) {
			vie -= degatsRecus;
			if(manager != null) {
				manager.notifier(new MessageNotification(this.nom + " -" + degatsRecus + "PV", MessageNotification.ACTION_MESSAGE_ASYNCHRONE));				
			}
		}else {
			if(manager != null) {
				manager.notifier(new MessageNotification(this.nom + " esquive l'attaque", MessageNotification.ACTION_MESSAGE_ASYNCHRONE));				
			}
		}
	}
	
	public void attaque(Personnage adversaire, GameManager manager) throws RemoteException {
		if(manager != null) {
			manager.notifier(new MessageNotification(this.nom + " attaque " + adversaire.getNom(), MessageNotification.ACTION_MESSAGE_ASYNCHRONE));
		}
		adversaire.recoitDegats(getDegatsAvecBonus(), manager);
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

	public Double getEsquive() {
		return esquive;
	}

	public void setEsquive(Double esquive) {
		this.esquive = esquive;
	}

	public Double getVitesse() {
		return vitesse;
	}

	public void setVitesse(Double vitesse) {
		this.vitesse = vitesse;
	}
	
}
