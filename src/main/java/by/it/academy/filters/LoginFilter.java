package by.it.academy.filters;

import by.it.academy.entities.User;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebFilter(urlPatterns = {"/user/create"})
public class LoginFilter extends HttpFilter {
    private UserService userService;
    private static final String ERROR_PAGE = "/pages/error/login_exists.jsp";

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        List<User> users = userService.readUsers();
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getLogin()
                .equals(req.getParameter("login")))
                .findFirst();
        if (userOptional.isPresent()) {
            req.getRequestDispatcher(ERROR_PAGE).forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig config) {
        userService = UserServiceImpl.getUserService();
    }

    @Override
    public void destroy() {

    }
}
