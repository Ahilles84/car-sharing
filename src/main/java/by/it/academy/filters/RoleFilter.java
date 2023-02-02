package by.it.academy.filters;

import by.it.academy.entities.UserType;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user/read"})
public class RoleFilter extends HttpFilter {
    private static final long serialVersionUID = 4141316242L;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        UserType userType = (UserType) session.getAttribute("userType");
        if (userType == UserType.ADMIN) {
            chain.doFilter(req, res);
        } else {
            req.getRequestDispatcher("/pages/error/auth_error.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
