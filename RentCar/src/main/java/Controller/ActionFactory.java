package Controller;

import Controller.action.BookingAction;
import Controller.action.CorrectionAction;
import Controller.action.LoginAction;
import Controller.action.RegistUserAction;
import Controller.action.ReviewAction;


public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory() ;
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("join")) {
			action = new RegistUserAction();
		}
		else if(command.equals("login")){
			action = new LoginAction();
		}
		else if(command.equals("booking")) {
			action = new BookingAction();
		}
		else if(command.equals("review")) {
			action = new ReviewAction();
		}
		else if(command.equals("correction")) {
			action = new CorrectionAction();
		}
		
		return action;
	}

}
