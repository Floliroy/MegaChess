package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import serveur.base.GameCreator;
import serveur.base.GameManager;
import serveur.implementation.NotificationImpl;


public class Client {
	
	public static final String SERVEUR_IP = "localhost";
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
        GameCreator createur = (GameCreator) Naming.lookup(URL + "/Createur");
        GameManager manage;
        NotificationImpl notification = new NotificationImpl();
        
       String nomPartie;
 
       if(Client.getInput() == 1) {
            nomPartie = createur.creerPartie();
            System.out.println("Creation de la partie " + nomPartie);
            
            manage = createur.getGameManager(nomPartie);
            Naming.rebind(URL + "/"+ nomPartie, manage);          
            
            /*---*/
            manage.ajouterNotification(notification);
            manage.rejoindrePartie("crt");
            
       }
        
       else {
            nomPartie = createur.trouverPartie();
            if(nomPartie == null) 
                System.out.println("Aucune partie trouvee");
            else {
                System.out.println("Partie trouvee : " + nomPartie);
                manage = createur.getGameManager(nomPartie);
                Naming.rebind(URL + "/"+ nomPartie, manage);
                              
                /*---*/
                
                manage.rejoindrePartie("rj");
            }
        }

       @SuppressWarnings("unused")
       int in = getInput();
        
        
    	

    }
}
