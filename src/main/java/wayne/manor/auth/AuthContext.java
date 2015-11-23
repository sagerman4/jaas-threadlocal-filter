package wayne.manor.auth;

/**
 * This thing should have auth stuff related to the current thread. That's about
 * it.
 *
 * @author J. Sager Davidson
 */
public class AuthContext {

    private AuthContext() {
    }

    private final static ThreadLocal<AuthState> threadLocal = new ThreadLocal<>();

    public static void setAuthState(final AuthState authState) {
        threadLocal.set(authState);
    }

    public static AuthState getAuthState() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
