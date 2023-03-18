package edu.umb.cs680.hw05.PrintingFramework;

public class LoggedOut implements State{
    private static SecurityContext ctx;
    private static State  LOState= new LoggedOut();
    @Override
    public void login(EncryptedString pwd){
            if (Authenticator.authenticate(ctx, pwd) ){
            State LoggedIN = new LoggedIn();
            SecurityContext SC = new SecurityContext();
            SC.changeState(LoggedIN);
            
        }   
        else{
            
        }                                                                             
    }
    @Override
    public void logout(){
        
    }
    public static void setSecurityContext(SecurityContext ctx) {
        System.out.println("");
		LoggedOut.ctx = ctx;
	}   
    public LoggedOut(){
    }
    public static State getInstance(){

        if (LOState == null) {
			LOState = new LoggedOut();
		}
		return LOState;
    }
}


