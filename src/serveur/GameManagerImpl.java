package serveur;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import partie.Jeu;
import partie.Joueur;

public class GameManagerImpl extends UnicastRemoteObject implements GameManager {
	
	private static final long serialVersionUID = 158417159317738834L;
	
	private String id;
    private Jeu jeu;

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
    public void joinGame(String name) throws RemoteException {
    	jeu.addJoueur(new Joueur(name));
    }
    
}
