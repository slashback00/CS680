package edu.umb.cs680.hw05.PrintingFramework;

public class LoggedIn implements State{
    private static SecurityContext ctx;
    private static LoggedIn LIobject=null;
    @Override
    public void login(EncryptedString pwd){
        if(ctx.isActive()){
            ctx.changeState(LoggedOut.getInstance());
            ctx.login(pwd);
        }
    }

    @Override
    public void logout(){
        ctx.changeState( LoggedOut.getInstance() );
    }

    public static void setSecurityContext(SecurityContext ctx) {
		LoggedIn.ctx = ctx;
	}   

     public LoggedIn( ){
    }

    public static LoggedIn getInstance(){
        if(LIobject == null){
          
            LIobject = new LoggedIn();
        }
        return LIobject;
    }
}