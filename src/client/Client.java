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
	
	public static final String SERVEUR_IP = "192.168.1.16";
	public static final String URL = "rmi://"+ SERVEUR_IP;
	
	 public static int getInput(){
        System.out.println("1 - Create \n2 - Join");
        
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void main(String []args) throws RemoteException, MalformedURLException, NotBoundException {

        @SuppressWarnings("unused")
		Registry registry = LocateRegistry.getRegistry(1099);
        GameCreator stubMaster = (GameCreator) Naming.lookup(URL + "/Creator");
        String gameName = null;

        // Creation d'une partie
        if(Client.getInput() == 1) {
            gameName = stubMaster.createGame();
            System.out.println("Game :" + gameName);

            GameManager stubSlave = (GameManager) Naming.lookup(URL + gameName);//IP
            stubSlave.joinGame("Player1");  
        }
        // Connection a une partie
        else {
            gameName = stubMaster.findGame();
            if(gameName == null)
                System.out.println("Aucune partie trouvee");
            else {
                System.out.println("Partie trouvee : " + gameName);
                GameManager stubSlave = (GameManager) Naming.lookup(URL + gameName);//IP

                stubSlave.joinGame("Player2");
            }
        }

        while(true);
        // Attaquer
        // Déplacer
        // Passer son tour
        
        
    }
}
