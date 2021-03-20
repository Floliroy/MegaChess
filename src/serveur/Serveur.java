package serveur;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import serveur.implementation.GameCreatorImpl;

public class Serveur {

	public static void main(String []args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        @SuppressWarnings("unused")
		Registry registry  = LocateRegistry.createRegistry(1099);
        GameCreatorImpl createur = new GameCreatorImpl();
        Naming.bind("Createur", createur);
    }
	
}
