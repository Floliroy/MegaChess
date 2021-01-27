package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import serveur.GameCreator;
import serveur.GameManager;

public class Client {
	
	 public static int getInput(){
	        System.out.println("1 - Create \n2 - Join");
	        Scanner sc = new Scanner(System.in);
	        return sc.nextInt();
	    }

	    public static void main(String []args) throws RemoteException, MalformedURLException, NotBoundException {

	        Registry registry = LocateRegistry.getRegistry(1099);
	        GameCreator stubMaster = (GameCreator) Naming.lookup("Creator");
	        String gameName = null;

	        if(Client.getInput() == 1) {
	            gameName = stubMaster.createGame();
	            System.out.println("Game :" + gameName);

	            GameManager stubSlave = (GameManager) Naming.lookup(gameName);
	            stubSlave.joinGame("Player1");
	        } else {
	            gameName = stubMaster.findGame();
	            if(gameName == null)
	                System.out.println("Aucune partie trouvee");
	            else {
	                System.out.println("Partie trouvee : " + gameName);
	                GameManager stubSlave = (GameManager) Naming.lookup(gameName);

	                stubSlave.joinGame("Player2");
	            }
	        }

	        while(true);
	    }
}
