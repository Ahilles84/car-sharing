package by.it.academy.filters;

import by.it.academy.dao.UserDAO;
import by.it.academy.entities.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user/create"})
public class CheckLoginFilter extends HttpFilter {
    private static final String LOGIN_NOT_UNIQUE_PAGE = "/pages/error/login_exists.jsp";
    private UserDAO userDAO;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String login = req.getParameter("Login");
        User user = userDAO.read(login);
        if (user != null) {
            req.getRequestDispatcher(LOGIN_NOT_UNIQUE_PAGE).forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init() {
        userDAO = UserDAO.getUserDao();
    }

    @Override
    public void destroy() {
    }
}
