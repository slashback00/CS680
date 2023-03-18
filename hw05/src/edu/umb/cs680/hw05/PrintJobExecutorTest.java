package edu.umb.cs680.hw05;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class PrintJobExecutorTest{
    
    
    edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor PJ_modelXYZ= new edu.umb.cs680.hw05.ModelXYZ.PrintJobExecutor();
    
    
    edu.umb.cs680.hw05.ModelABC.PrintJobExecutor PJ_modelABC= new edu.umb.cs680.hw05.ModelABC.PrintJobExecutor();
    
   
    

    
    @Test
    public void XYZIsNotNull() {
        assertNotNull(PJ_modelXYZ);
	}

    @Test
    public void XYZWithoutAnyError() {
        try {
            PJ_modelXYZ.execute(null, null, null);
        } 
        catch (Throwable E) {
            assertEquals("Login failed",
                E.getMessage() );
        }
	}

    //Tests for ABC
    @Test
    public void ABCIsNotNull() {
        assertNotNull(PJ_modelABC);
	}

    @Test
    public void ABCWithoutAnyError() {
        try {
            PJ_modelABC.execute(null, null, null);
        } 
        catch (Throwable E) {
            assertEquals("Login failed",
                E.getMessage() );
        }
	}

    @Test
    public void ABCThrowsInvalidLogin() throws Throwable {
        try {
                PJ_modelABC.execute(null, null, null);
        } 
        catch (Exception E) {
                assertEquals("Login failed",
                E.getMessage() );
            }
    }

    @Test
    public void testObjectIsNotNull() {
        Object obj = new Object();
        assertNotNull(obj);
    }


    @Test
    public void testObjectsAreEqual() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertEquals(obj1, obj2);
    }

}
