package by.it.academy.filters;

import by.it.academy.entities.User;
import by.it.academy.services.ServiceInstance;
import by.it.academy.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.constants.Constants.LOGIN_EXISTS_ERROR_PAGE;

@WebFilter(urlPatterns = {"/user/create"})
public class CheckLoginFilter extends HttpFilter {
    private UserService userService;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String login = req.getParameter("login");
        User user = userService.getDAOInstance().read(login);
        if (user != null) {
            req.getRequestDispatcher(LOGIN_EXISTS_ERROR_PAGE).forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init() {
        userService = ServiceInstance.USER_SERVICE.getUserService();
    }

    @Override
    public void destroy() {
    }
}
