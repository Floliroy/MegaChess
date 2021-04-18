package serveur.base;

import java.rmi.Remote;
import java.rmi.RemoteException;

import partie.Jeu;
import personnage.Personnage;

public interface GameManager extends Remote {

	void rejoindrePartie(String name, Notification notification) throws RemoteException;
	
	void notifier(MessageNotification message) throws RemoteException;
	
	Jeu getJeu() throws RemoteException;

	void placerPersonnage(Personnage personnage, Integer ligne, Integer colonne) throws RemoteException;

	void addPersonnageToEquipe(Personnage personnage, Integer joueur) throws RemoteException;
}
