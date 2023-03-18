package edu.umb.cs680.hw04;

public class SecurityContext {
    private State state;
    private User user;

    public SecurityContext(User user) {
        this.user = user;
        this.state = new LoggedOut();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void login(EncryptedString pass) {
        state.login(pass);
    }

    public void logout() {
        state.logout();
    }

    public State getState() {
        return state;
    }

    public boolean isActive() {
        return true;
    }

    public User getUser() {
        return user;
    }

    public void changeState(State state1) {
        this.state = state1;
    }
}

