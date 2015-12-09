package com.github.sagerman4.auth;

/**
 * This thing is just a model class to house some information about the current
 * auth state.
 *
 * @author J. Sager Davidson
 */
public class AuthState {

    private String userId;

    public AuthState(final String userId) {
        this.userId = userId;
    }

    public AuthState(final AuthState authState) {
        this.userId = authState.userId;
    }

    public void setAuthState(final AuthState authState) {
        this.userId = authState.userId;
    }

    public String getUserId() {
        return userId;
    }
}
