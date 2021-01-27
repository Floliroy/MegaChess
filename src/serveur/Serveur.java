package serveur;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {

	public static void main(String []args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        Registry registry  = LocateRegistry.createRegistry(1099);
        GameCreatorImpl skeleton = new GameCreatorImpl();
        Naming.bind("Creator", skeleton);
    }
	
}
