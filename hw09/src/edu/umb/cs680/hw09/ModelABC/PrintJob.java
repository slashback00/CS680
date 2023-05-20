package edu.umb.cs680.hw09.ModelABC;
import edu.umb.cs680.hw09.ModelABC.PrintJob;
import edu.umb.cs680.hw09.PrintingFramework.*;

public class PrintJob implements Command{
    private PrintJobExecutor executor;
    private EncryptedString pwd;
    private SecurityContext ctx;


    public void execute(Printer p) throws Throwable {
        p.print();
    }


    @Override
    public void execute() throws Throwable {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
}


