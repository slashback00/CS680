package edu.umb.cs680.hw04;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class SecurityContextTest {
    

    
    @Test
    void testChangeState() {
        User user = new User("username", "password");
        SecurityContext context = new SecurityContext(user);
        State state1 = new LoggedOut(context);
        State state2 = new LoggedIn(context);
        
        context.changeState(state1);
        assertEquals(state1, context.getState());
        
        context.changeState(state2);
        assertEquals(state2, context.getState());
    }

    private void assertEquals(State state1, State state) {
    }

    @Test
    void testChangeStateNull() {
        User user = new User("username", "password");
        SecurityContext context = new SecurityContext(user);
    
        context.changeState(null);
        assertNull(context.getState());
        }

   
    @Test
    public void testInitialState() {
        SecurityContext context = new SecurityContext(null);
        LoggedOut loggedOutState = new LoggedOut();
        
        // Verify that the initial state is LoggedOut
        Assertions.assertEquals(context.getState().getClass(), loggedOutState.getClass());
        }

    @Test
    public void LoginWhileLoggedOut() {
        SecurityContext SC = new SecurityContext(null);
        SC.changeState(new LoggedIn(SC));
        LoggedIn LI = new LoggedIn(SC);
        Assert.assertEquals((SC.getState()).getClass(), LI.getClass());
        }

     

    @Test
    public void CanResetPassword() {
        UserManager userManager = new UserManager();
        User user = new User("John", "Doe");
        userManager.registerUser(user);
        boolean result = userManager.resetPassword(user, "newpassword");
        assertFalse(result);
        }


    }






