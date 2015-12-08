package sharkmeat.auth;

import java.io.IOException;
import javax.servlet.Filter;
import java.security.Principal;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author J. Sager Davidson
 */
public class JaasLoginFilter implements Filter
{

    private static final Logger log = LoggerFactory.getLogger(JaasLoginFilter.class);

    private Principal getJaasPrincipal(final ServletRequest request)
    {
        final HttpServletRequest servletRequestCast = (HttpServletRequest) request;
        if (null == servletRequestCast)
        {
            log.info("ServletRequestCast null");
            return null;
        }

        final Principal principal = servletRequestCast.getUserPrincipal();
        return principal;
    }

    @Override
    public void init(FilterConfig fc) throws ServletException
    {
        // do nothing
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException
    {
        final Principal principal = getJaasPrincipal(servletRequest);
        final String userId = principal.getName();

        AuthContext.setAuthState(new AuthState(userId));

        try
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        finally
        {
            if (null != AuthContext.getAuthState() && servletRequest instanceof HttpServletRequest)
            {
                AuthContext.remove();
            }
        }
    }

    @Override
    public void destroy()
    {
        // do nothing
    }
}
