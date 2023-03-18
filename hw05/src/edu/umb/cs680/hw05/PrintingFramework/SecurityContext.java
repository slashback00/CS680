package edu.umb.cs680.hw05.PrintingFramework;

public class SecurityContext {
    private State currentState;

    public SecurityContext(){
        this.currentState=LoggedOut.getInstance();
    }
    public void changeState(State newState){
        this.currentState=newState;
    }
    public void login(EncryptedString pwd){
       
        currentState.login(pwd);
    }

    public void logout(){
        
        currentState.logout();
    }

    public State getState(){
        return this.currentState;
    }

    public boolean isActive(){
        return true;
    }
    public static SecurityContext getInstance(SecurityContext ctx) {
		if (ctx == null) 
        {
			ctx = new SecurityContext();
			ctx.changeState(new LoggedOut());
		}
		return ctx;
	}
}