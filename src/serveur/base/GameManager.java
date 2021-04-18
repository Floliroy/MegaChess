package serveur.base;

import java.rmi.Remote;
import java.rmi.RemoteException;

import partie.Jeu;
import partie.plateau.Case;
import personnage.Equipe;
import personnage.Personnage;

public interface GameManager extends Remote {

	void rejoindrePartie(String name, Notification notification) throws RemoteException;
	
	void notifier(MessageNotification message) throws RemoteException;
	
	Jeu getJeu() throws RemoteException;

	void creerEquipe(Equipe equipe, Boolean createurPartie) throws RemoteException;

	void deplacerPersonnage(Case prevCase, Integer ligne, Integer colonne) throws RemoteException;

	void subitDegats(Case caseDefenseur, Personnage attaquant) throws RemoteException;

	
}
