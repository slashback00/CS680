package edu.umb.cs680.hw05.PrintingFramework;

public abstract class PrintJobExecutor{

    public final void execute(PrintJob job, EncryptedString pwd, SecurityContext ctx)  throws Throwable{
        doAuthentication(pwd,  ctx);
        doAccessControl();
        doPrint();
        doErrorHandling();
    }
  
    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception;
    
    protected abstract void doAccessControl();
    
    protected abstract void doPrint() throws Exception;
    
    protected abstract void doErrorHandling();
}