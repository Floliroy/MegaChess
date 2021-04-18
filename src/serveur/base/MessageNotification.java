package serveur.base;

import java.io.Serializable;

public class MessageNotification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7758924803940455164L;
	
	public static final int ACTION_ECRICE_MESSAGE = 0;
	public static final int ACTION_FIN_CREER_EQUIPE = 1;
	public static final int ACTION_MESSAGE_ASYNCHRONE = 2;
	
	
	private String message;
	private Integer action;

	public MessageNotification(String message, Integer action) {
		this.message = message;
		this.action = action;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	
	
}
