package util;

import java.util.ArrayList;

import personnage.Personnage;
import personnage.personnages.*;

public class Util {

	public static Personnage getPersonnageAvecNom(String nom) {
		for(Personnage personnage : getAllPersonnages()) {
			if(personnage.getNom().equals(nom)) {
				return personnage;
			}
		}
		return null;
	}
	
	public static Personnage getPersonnageAvecNom(String nom, ArrayList<Personnage> personnages) {
		for(Personnage personnage : personnages) {
			if(personnage.getNom().equals(nom)) {
				return personnage;
			}
		}
		return null;
	}
	
	public static ArrayList<Personnage> getAllPersonnages(){
		ArrayList<Personnage> personnages = new ArrayList<>();
		personnages.add(new Ahri());
		personnages.add(new Fizz());
		personnages.add(new Illaoi());
		personnages.add(new Jarvan());
		personnages.add(new Kayle());
		personnages.add(new Kled());
		personnages.add(new Poppy());
		personnages.add(new Pyke());
		personnages.add(new Quinn());
		personnages.add(new Shyvana());
		personnages.add(new Sion());
		personnages.add(new Sona());
		personnages.add(new Swain());
		personnages.add(new Talon());
		personnages.add(new Wukong());
		personnages.add(new Yasuo());
		return personnages;
	}
	
}
