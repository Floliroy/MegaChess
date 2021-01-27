package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameManager extends Remote {
	
	String sayHello() throws RemoteException;
	
	void joinGame(String name) throws RemoteException;
	
}
