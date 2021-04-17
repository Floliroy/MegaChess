package serveur.base;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameManager extends Remote {
	
	void rejoindrePartie(String name) throws RemoteException;

	void ajouterNotification(Notification notification) throws RemoteException;
	
	
}
