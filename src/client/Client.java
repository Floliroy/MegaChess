package client;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import serveur.base.GameCreator;
import serveur.base.GameManager;
import serveur.base.MessageNotification;
import serveur.implementation.NotificationImpl;
import util.Clavier;


public class Client {
	
	public static final String SERVEUR_IP = "localhost";
	public static final String URL = "rmi://"+ SERVEUR_IP;
	private static NotificationImpl notification;
	
	private static MessageNotification waitNotification() {
		while(notification.getMessage() == null);
		MessageNotification message = notification.getMessage();
		notification.setMessage(null);
		return message;
	}

    public static void main(String []args) throws NotBoundException, IOException {

	    @SuppressWarnings("unused")
		Registry registry = LocateRegistry.getRegistry(1099);
	    GameCreator creator = (GameCreator) Naming.lookup(URL + "/Createur");
	    GameManager manager = null;
	    Boolean createurPartie = false;
	    notification = new NotificationImpl();

        System.out.println("1 - Créer partie \n2 - Rejoindre partie");
		if(Clavier.entrerClavierInt() == 1) {
			String nomPartie = creator.creerPartie();
			System.out.println("Création de la partie : " + nomPartie);
			
			manager = creator.getGameManager(nomPartie);
			Naming.rebind(URL + "/"+ nomPartie, manager);   
			System.out.println("\nEntrez votre nom : ");
			manager.rejoindrePartie(Clavier.entrerClavierString(), notification);
			createurPartie = true;
		} else {
			String nomPartie = creator.trouverPartie();
	        if(nomPartie == null) {
	            System.out.println("Aucune partie trouvee");
	        } else {
				System.out.println("Partie trouvee : " + nomPartie);
				manager = creator.getGameManager(nomPartie);
				Naming.rebind(URL + "/"+ nomPartie, manager);
				
				System.out.println("Entrez votre nom :");
				manager.rejoindrePartie(Clavier.entrerClavierString(), notification);
	        }
	    }
		waitNotification();
		if(createurPartie) {
			//Lancer partie
			System.out.println("\nAppuyez sur entrée pour lancer la partie");
			System.in.read();
			//Envoie notif debut partie
			manager.notifier(new MessageNotification("Début de la Partie\n", MessageNotification.ACTION_ECRICE_MESSAGE));
			waitNotification();
		}
		
		//Blabla je crée mon équipe et j'envoie
		manager.getJeu().creerEquipe(manager, createurPartie);
		System.out.println("\nEn attente de l'autre joueur ...");
		manager.notifier(new MessageNotification("\nLes équipes sont prêtes !", MessageNotification.ACTION_FIN_CREER_EQUIPE));
		waitNotification();

		//Debut partie
		Boolean partieFinie = createurPartie ? null : false;
		do {
			if(partieFinie != null) {
				waitNotification();
			}
			partieFinie = manager.getJeu().jouerTour(manager, createurPartie);
			String message = !partieFinie ? "\nFin du tour..." : "";
			manager.notifier(new MessageNotification(message, MessageNotification.ACTION_ECRICE_MESSAGE));
			waitNotification();
		}while(!partieFinie);
		System.err.println("\nFin de la partie !");
    }
}
