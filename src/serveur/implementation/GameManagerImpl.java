package serveur.implementation;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import partie.Jeu;
import partie.Joueur;
import partie.plateau.Case;
import personnage.Equipe;
import personnage.Personnage;
import serveur.base.GameManager;
import serveur.base.MessageNotification;
import serveur.base.Notification;

public class GameManagerImpl extends UnicastRemoteObject implements GameManager {
	
	private static final long serialVersionUID = 158417159317738834L;
	
	private String id;
    private Jeu jeu;
    private ArrayList<Notification> notifications;
 
    /**
     * Constructeur 
     * @param gameId
     * @throws RemoteException
     * @throws AlreadyBoundException
     */
    public GameManagerImpl(String gameId) throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.getRegistry();
        registry.bind(gameId,this);

        this.id= gameId;
        this.jeu = new Jeu();
        this.notifications = new ArrayList<>();
    }

    @Override
	public Jeu getJeu() throws RemoteException {
        return this.jeu;
    }
    
    public String getId(){
        return this.id;
    }

    /**
     * Permet de notifier tous les joueurs
     */
    @Override
    public void notifier(MessageNotification message) throws RemoteException {
    	for(Notification notification : notifications) {
    		try {
    			if(message.getAction() != MessageNotification.ACTION_FIN_CREER_EQUIPE || jeu.bothEquipeComplete()) {
    				notification.notifier(message);
    			}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    	}
    }
    
    /**
     * Permet a un joueur de rejoindre la partie
     */
    @Override
    public void rejoindrePartie(String name, Notification notification) throws RemoteException {	
    	jeu.addJoueur(new Joueur(name));
    	notifier(new MessageNotification("\n" + name + " a rejoint la partie", MessageNotification.ACTION_ECRICE_MESSAGE));
    	notifications.add(notification);
    }

    /**
     * Permet a un joueur de créer son équipe
     */
	@Override
	public void creerEquipe(Equipe equipe, Boolean createurPartie) throws RemoteException {
		Joueur joueur = jeu.getJoueurs().get(createurPartie ? 0 : 1);
		//Pour tous les personnages
		for(Personnage personnage : equipe) {
			//On les ajoutes à l'équipe
			joueur.getEquipe().add(personnage);
			//On les places sur le plateau
			Case c = createurPartie ? jeu.getPlateau().getFirstCaseLeft() : jeu.getPlateau().getFirstCaseRight();
			jeu.getPlateau().placerPersonnage(personnage, c.getLigne(), c.getColonne());
		}
	}

	/**
	 * Permet e un joueur de deplacer son personnage
	 */
	@Override
	public void deplacerPersonnage(Case prevCase, Integer ligne, Integer colonne) throws RemoteException {
		//On récupère le personnage sur la case de depart
		Personnage personnage = jeu.getPlateau().getCase(prevCase.getLigne(), prevCase.getColonne()).getPersonnage();
		//On le déplace sur sa nouvelle case
		jeu.getPlateau().placerPersonnage(personnage, ligne, colonne);
		//On affiche le plateau aux joueurs
		notifier(new MessageNotification(jeu.getPlateau().print(), MessageNotification.ACTION_MESSAGE_ASYNCHRONE));
	}

	/**
	 * Permet a un personnage d'en attaquer un autre
	 */
	@Override
	public void subitDegats(Case caseDefenseur, Personnage attaquant) throws RemoteException {
		//On récupère le personnage sur la case du defenseur
		Personnage adversaire = jeu.getPlateau().getCase(caseDefenseur.getLigne(), caseDefenseur.getColonne()).getPersonnage();
		//On attaque
		attaquant.attaque(adversaire, this);
		//On traite le cas ou le defenseur est mort
		if(!adversaire.isVivant()) {
			notifier(new MessageNotification(adversaire.getNom() + " est mort !", MessageNotification.ACTION_MESSAGE_ASYNCHRONE));
			jeu.getPlateau().getCase(adversaire).setPersonnage(null);
		}
	}
    
    
    
}
