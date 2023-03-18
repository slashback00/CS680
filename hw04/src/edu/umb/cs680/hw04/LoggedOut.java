package edu.umb.cs680.hw04;

public class LoggedOut implements State {
    private SecurityContext context;
    
    public LoggedOut(SecurityContext context) {
        this.context = context;
    }
    
    public LoggedOut() {
    }

    @Override
    public void login(EncryptedString pass) {
        String decrypted = decryptPassword(pass.getPass());
        boolean authenticated = authenticate(decrypted);
        if (authenticated) {
            
            context.changeState(new LoggedIn(context));
        } else {
           
        }
    }
    
    @Override
    public void logout() {
        
    }
    
    private String decryptPassword(String encrypted) {
        // implementation to decrypt password
        return "decryptedPassword";
    }
    
    private boolean authenticate(String decrypted) {
        // implementation to authenticate user
        return true;
    }
}

