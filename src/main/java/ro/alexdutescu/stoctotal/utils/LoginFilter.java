/*
 * This code is not to be used by any third party who is not a member of DoubleA team.
 */
package ro.alexdutescu.stoctotal.utils;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.omnifaces.filter.HttpFilter;

/**
 *
 * @author Alex Dutescu
 */
@WebFilter("/index.xhtml")
public class LoginFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, HttpSession session, FilterChain chain)
            throws ServletException, IOException {

        if (session != null && session.getAttribute("utilizator") != null) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.xhtml");
        }
    }

}
