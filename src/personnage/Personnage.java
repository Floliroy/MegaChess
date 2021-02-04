package personnage;

public abstract class Personnage {

	private String nom;
	private Integer vie;
	private Integer vieBase;
	private Integer degats;
	private Integer deplacements;
	private Integer portee;
	
	private Equipe equipe;

	public Personnage(String nom, Integer vie, Integer degats, Integer deplacements, Integer portee) {
		this.nom = nom;
		this.vie = vie;
		this.vieBase = vie;
		this.degats = degats;
		this.deplacements = deplacements;
		this.portee = portee;
	}
	
	public Integer getVieAvecBonus() {
		return this.vie + this.equipe.getVieBonus(this);
	}
	public Integer getVieBaseAvecBonus() {
		return this.vieBase + this.equipe.getVieBonus(this);
	}
	public Integer getDegatsAvecBonus() {
		return this.degats + this.equipe.getDegatsBonus(this);
	}
	public Integer getDeplacementsAvecBonus() {
		return this.deplacements + this.equipe.getDeplacementsBonus(this);
	}
	public Integer getPorteeeAvecBonus() {
		return this.portee + this.equipe.getPorteeBonus(this);
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
	
}
