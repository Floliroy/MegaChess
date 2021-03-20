package serveur.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import serveur.base.Notification;

public class NotificationImpl extends UnicastRemoteObject implements Notification {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotificationImpl() throws RemoteException {
		super();
	}

	@Override
	public void notifier(String message) {
		System.out.println(message);
	}
}
