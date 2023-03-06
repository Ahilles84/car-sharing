package by.it.academy.filters;

import by.it.academy.entities.Role;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.it.academy.constants.Constants.ADMIN_PAGE;

@WebFilter(urlPatterns = {"/index.jsp"})
public class RoleFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Role role = (Role) session.getAttribute("role");
        if (role == null || role == Role.USER) {
            chain.doFilter(req, res);
        } else {
            req.getRequestDispatcher(ADMIN_PAGE).forward(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}
