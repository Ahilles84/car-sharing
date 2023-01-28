package by.it.academy.filters;

import by.it.academy.entities.User;
import by.it.academy.entities.UserType;
import by.it.academy.repositories.UserRepositoryImpl;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = {"/user/read"})
public class AuthorisationFilter extends HttpFilter {
    private static final long serialVersionUID = 4141316242L;
    private UserService userService;
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if(null != session || null != session.getAttribute("userType")){
            UserType userType = (UserType) session.getAttribute("userType");
            if(userType == UserType.ADMIN){
                chain.doFilter(req, res);
            } else {
                req.getRequestDispatcher("/pages/error/auth_error.jsp").forward(req, res);
            }
        } else {
            List<User> users = userService.readUsers();
            users.stream()
                    .filter(user -> user.getLogin().equals(req.getParameter("login")))
                    .findFirst()
                    .ifPresent(user -> session.setAttribute("userType", user.getUserType()));
        }
    }
    @Override
    public void init(FilterConfig config) {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }
    @Override
    public void destroy() {

    }
}
