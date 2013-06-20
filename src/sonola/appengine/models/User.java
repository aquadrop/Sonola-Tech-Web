package sonola.appengine.models;

import java.io.Serializable;

public class User implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8591564879140991666L;
	private String username;
	
	

	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}

