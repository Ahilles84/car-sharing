package by.it.academy.filters;


import by.it.academy.entities.User;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = {"/user/create"})
public class LoginFilter extends HttpFilter {
    private static final long serialVersionUID = 10297454264L;
    private static final String ERROR_PAGE = "/pages/error/login_exists.jsp";

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        ServletContext servletContext = req.getSession().getServletContext();
        UserService userService = (UserServiceImpl) servletContext.getAttribute("userService");
        List<User> users = userService.readUsers();
        String login = req.getParameter("login");
        if (users.isEmpty()) {
            req.getRequestDispatcher("/user/create").forward(req, res);
        } else {
            for (User item : users) {
                if (item.getLogin().equals(login)) {
                    req.getRequestDispatcher(ERROR_PAGE).forward(req, res);
                }
            }
        }
    }


    @Override
    public void destroy() {

    }
}
