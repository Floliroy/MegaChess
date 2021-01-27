package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameCreator extends Remote {

    String createGame() throws RemoteException;
    
    String findGame() throws RemoteException;
    
}
