package serveur.base;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameCreator extends Remote {

    String creerPartie() throws RemoteException;
    
    String trouverPartie() throws RemoteException;
    
    GameManager getGameManager(String nomPartie) throws RemoteException;
    
}
