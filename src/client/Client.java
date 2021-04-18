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
			System.out.println("Creation de la partie " + nomPartie);
			
			manager = creator.getGameManager(nomPartie);
			Naming.rebind(URL + "/"+ nomPartie, manager);   
			System.out.println("Entrez votre nom :");
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
			System.out.println("Appuyez sur entrée pour lancer la partie");
			System.in.read();
			//Envoie notif debut partie
			manager.notifier(new MessageNotification("Début de la Partie", MessageNotification.ACTION_ECRICE_MESSAGE));
			waitNotification();
		}
		
		//Blabla je crée mon équipe et j'envoie
		manager.getJeu().creerEquipe(manager, createurPartie);
		System.out.println("En attente de l'autre joueur ...");
		manager.notifier(new MessageNotification("Les équipes sont prêtes !", MessageNotification.ACTION_FIN_CREER_EQUIPE));
		waitNotification();

		//Debut partie
		Boolean partieFinie = createurPartie ? null : false;
		do {
			if(partieFinie != null) {
				System.err.println("Salut");
				waitNotification();
				System.err.println("Hello");
			}
			partieFinie = manager.getJeu().jouerTour(manager, createurPartie);
			manager.notifier(new MessageNotification("Fin du tour...", MessageNotification.ACTION_ECRICE_MESSAGE));
			waitNotification();
			System.err.println("Coucou");
		}while(!partieFinie);
		System.err.println("ALED ?");
    }
}
