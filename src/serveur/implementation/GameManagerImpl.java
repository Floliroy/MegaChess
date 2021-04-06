package serveur.implementation;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import partie.Jeu;
import partie.Joueur;
import serveur.base.GameManager;
import serveur.base.Notification;

public class GameManagerImpl extends UnicastRemoteObject implements GameManager {
	
	private static final long serialVersionUID = 158417159317738834L;
	
	private String id;
    private Jeu jeu;
    private Notification notification;
 
    public GameManagerImpl(String gameId) throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.getRegistry();
        registry.bind(gameId,this);

        this.id= gameId;
        this.jeu = new Jeu();
    }

	public Jeu getJeu() {
        return this.jeu;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello";
    }

    @Override
    public void ajouterNotification(Notification notification) {
    	if(this.notification == null) 
    		this.notification = notification;
    	else
    		System.out.println("Notification deja presente");
    }
    
    @Override
    public void rejoindrePartie(String name) throws RemoteException {	
    	jeu.addJoueur(new Joueur(name));
    	notification.notifier("Un joueur a ete ajoute ");
    }
 
    
    
}
