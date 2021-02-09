package controller;

import model.Principal;
import view.View;

public class Controller {
	
	private Principal principal;
	private View view;
	
	public Controller() {
		super();
		this.principal = new Principal();
		this.view = new View(this);
	
	}

	public Principal getPrincipal() {
		return principal;
	}
	
	public void cattleDangerCheck() {
		principal.cattleDangerCheck();
	}
	

}
