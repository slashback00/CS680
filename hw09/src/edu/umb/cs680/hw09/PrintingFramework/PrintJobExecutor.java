package edu.umb.cs680.hw09.PrintingFramework;

import edu.umb.cs680.hw09.ModelABC.PrintJob;

public abstract class PrintJobExecutor {

    public PrintJobExecutor(PrintJob printJob, String password, Object obj) {
    }

    public final void execute(Command job, EncryptedString pwd, SecurityContext ctx) throws Throwable {
        job.execute();
        doAuthentication(pwd, ctx);
        doAccessControl();
        doPrint();
        doErrorHandling();
    }

    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception;

    protected abstract void doAccessControl();

    protected abstract void doPrint() throws Exception; /// Authentication karni hai user ki... call PrintJob ka excecute method..

    protected abstract void doErrorHandling();
}

