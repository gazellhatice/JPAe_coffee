package Filter;

import Entity.Users;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Hatice
 */

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;

        String url = request.getRequestURI();

        HttpSession session = request.getSession(false); // Use getSession(false) to prevent creating a new session

        Users user = null;

        if (session != null) {
            user = (Users) session.getAttribute("validUser");
        }

        if (user == null) {
            if (url.contains("logout") || url.contains("private") || url.contains("admin.xhtml")) {
                response.sendRedirect(request.getContextPath() + "/login.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }
        } else {
            if (url.contains("register")) {
                response.sendRedirect(request.getContextPath() + "/index.xhtml");
            } else if (url.contains("logout")) {
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/login.xhtml");
            } else if (url.contains("admin.xhtml")) {
                // Check if the logged-in user is "test"
                if (user.getUsername().equals("test") && user.getPassword().equals("123456789")) {
                    fc.doFilter(sr, sr1);
                } else {
                    response.sendRedirect(request.getContextPath() + "/index.xhtml");
                }
            } else {
                fc.doFilter(sr, sr1);
            }
        }
    }
}

