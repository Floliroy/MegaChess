package serveur.implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map.Entry;

import serveur.base.GameCreator;

public class GameCreatorImpl extends UnicastRemoteObject implements GameCreator {
	
	private static final long serialVersionUID = -360720568897070466L;
	
	private HashMap<String,GameManagerImpl> list;

    public GameCreatorImpl() throws RemoteException {
        list = new HashMap<String,GameManagerImpl>();
    }

    public String generateId(){
        return "partie"+(list.size() + 1);
    }
    
    @Override
    public String creerPartie() {
        String id = generateId();
        System.out.println("Creation de " + id);
        try {
            list.put(id, new GameManagerImpl(id));
            System.out.println("La partie a bien ete cree");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public String trouverPartie() throws RemoteException{
        // Recuperation du premier GameManager avec une place de libre
        GameManagerImpl gm = null;

        for(Entry<String, GameManagerImpl> set : list.entrySet()) {
        	if(!set.getValue().getJeu().isComplet()) {
        		gm = set.getValue();
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
    public GameManagerImpl getGameManager(String nomPartie) throws RemoteException {
    	return list.get(nomPartie);
    }

}
