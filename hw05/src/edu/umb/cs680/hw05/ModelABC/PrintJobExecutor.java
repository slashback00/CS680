package edu.umb.cs680.hw05.ModelABC;
import edu.umb.cs680.hw05.PrintingFramework.*;
public class PrintJobExecutor extends edu.umb.cs680.hw05.PrintingFramework.PrintJobExecutor{
    String loginStatus="";
    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception{
        
      
        try {
			State LI = new LoggedIn();
            ctx.changeState(LI);
            loginStatus= ctx.getState().getClass().toString().substring(43);
            
		}
		catch(NullPointerException e) {
			
		}
    }

    @Override
    protected  void doAccessControl(){
        
    }

    @Override
    protected  void doPrint() throws Exception{
        if( loginStatus.equals("LoggedIn" )){
            
           
        }
        else{
           
            throw new Exception("Login failed");
        }
       
    }

    @Override
    protected  void doErrorHandling(){
        
    }

   
        
}



    
    
