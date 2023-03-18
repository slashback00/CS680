package edu.umb.cs680.hw04;

public class LoggedIn implements State {
    private SecurityContext context;
    
    public LoggedIn(SecurityContext context) {
        this.context = context;
    }
    
    @Override
    public void login(EncryptedString pass) {
        if (context.isActive()) {
            
        } else {
            String decrypted = decryptPassword(pass.getPass());
            boolean authenticated = authenticate(decrypted);
            if (authenticated) {
                
                context.changeState(new LoggedIn(context));
            } else {
                
            }
        }
    }

    private boolean authenticate(String decrypted) {
        return false;
    }

    private String decryptPassword(String pass) {
        return null;
    }

    @Override
    public void logout() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }
    
}

