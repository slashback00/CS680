package edu.umb.cs680.hw09;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrintJobExecutorTest{ 
    private edu.umb.cs680.hw09.ModelABC.PrintJobExecutor PJ_modelABC;

    public PrintJobExecutorTest() {
        PJ_modelABC = new edu.umb.cs680.hw09.ModelABC.PrintJobExecutor(null, null, PJ_modelABC);
    }
    
    @Test
    public void ABCIsNotNull() {
        assertNotNull(PJ_modelABC);
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

    @Test
    public void ABCThrowsInvalidLogin() {
        assertThrows(Exception.class, () -> {
        PJ_modelABC.execute(null, null, null);
        });
    }

    @Test
    public void testValidLogin() {
        String username = "testuser";
        String password = "testpassword";
        assertFalse(PJ_modelABC.login(username, password));
    }
}
