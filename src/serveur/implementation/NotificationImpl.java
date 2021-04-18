package serveur.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import serveur.base.MessageNotification;
import serveur.base.Notification;

public class NotificationImpl extends UnicastRemoteObject implements Notification {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MessageNotification message;

	public NotificationImpl() throws RemoteException {
		super();
	}

	@Override
	public void notifier(MessageNotification message) throws RemoteException  {
		System.out.println(message.getMessage());
		this.message = message;
	}

	public synchronized MessageNotification getMessage() {
		return message;
	}

	public void setMessage(MessageNotification message) {
		this.message = message;
	}
}
