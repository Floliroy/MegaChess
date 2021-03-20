package serveur.implementation;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import serveur.base.GameCreator;
import serveur.base.GameManager;

public class GameCreatorImpl extends UnicastRemoteObject implements GameCreator {
	
	private static final long serialVersionUID = -360720568897070466L;
	
	private ArrayList<GameManagerImpl> list;

    public GameCreatorImpl() throws RemoteException {
        list = new ArrayList<GameManagerImpl>();
    }

    public String generateId(){
        return "partie"+(list.size() + 1);
    }

    public void addGame(String gameId) throws RemoteException, AlreadyBoundException {
        list.add(new GameManagerImpl(gameId));
        System.out.println("La partie a bien ete cree");
    }

    @Override
    public String creerPartie() {
        String id = generateId();
        System.out.println("Creation de " + id);
        try {
            addGame(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public String trouverPartie(){
        // Recuperation du premier GameManager avec une place de libre
        GameManagerImpl gm = null;

        for(int cmpt = 0; cmpt < list.size(); cmpt++){
            if(!list.get(cmpt).getJeu().isComplet()){
                gm = list.get(cmpt);
                System.out.println("Partie trouvee " + gm.getId());
                break;
            }
        }

        // On verifie qu'une place a bien ete trouvee
        if(gm != null){
            String id = gm.getId();
            System.out.println("Tentative de connexion a " + id);
            return id;
        }
        else
            return null;
    }
    
    @Override
    public GameManager getGameManager(String nomPartie)throws RemoteException {
    	int cmpt = 0;
    	while(cmpt < list.size()) {
    		if(list.get(cmpt).getId().equals(nomPartie))
    			return list.get(cmpt);
    		cmpt ++;
    	}
    	return null;
    }

}
