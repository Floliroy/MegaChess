package serveur.base;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Notification extends Remote{

	
	public void notifier(String message) throws RemoteException;


}
