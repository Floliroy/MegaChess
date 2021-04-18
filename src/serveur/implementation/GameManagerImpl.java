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
    
    @Override
    public void rejoindrePartie(String name, Notification notification) throws RemoteException {	
    	jeu.addJoueur(new Joueur(name));
    	notifier(new MessageNotification(name + " a rejoint la partie", MessageNotification.ACTION_ECRICE_MESSAGE));
    	notifications.add(notification);
    }

	@Override
	public void creerEquipe(Equipe equipe, Boolean createurPartie) throws RemoteException {
		Joueur joueur = jeu.getJoueurs().get(createurPartie ? 0 : 1);
		for(Personnage personnage : equipe) {
			joueur.getEquipe().add(personnage);
			Case c = createurPartie ? jeu.getPlateau().getFirstCaseLeft() : jeu.getPlateau().getFirstCaseRight();
			jeu.getPlateau().placerPersonnage(personnage, c.getLigne(), c.getColonne());
		}
	}

	@Override
	public void deplacerPersonnage(Case prevCase, Integer ligne, Integer colonne) throws RemoteException {
		Personnage personnage = jeu.getPlateau().getCase(prevCase.getLigne(), prevCase.getColonne()).getPersonnage();
		jeu.getPlateau().placerPersonnage(personnage, ligne, colonne);
	}

	@Override
	public void subitDegats(Case caseDefenseur, Personnage attaquant) throws RemoteException {
		Personnage adversaire = jeu.getPlateau().getCase(caseDefenseur.getLigne(), caseDefenseur.getColonne()).getPersonnage();
		adversaire.recoitDegats(attaquant.getDegatsAvecBonus());
		if(!adversaire.isVivant()) {
			System.out.println(adversaire.getNom() + " est mort !");
			jeu.getPlateau().getCase(adversaire).setPersonnage(null);
		}else {
			System.out.println("Il reste " + adversaire.getVieAvecBonus() + "PV a " + adversaire.getNom());
		}
	}
    
    
    
}
