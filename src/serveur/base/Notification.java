package serveur.base;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Notification extends Remote {

	public void notifier(MessageNotification message) throws RemoteException;

}
