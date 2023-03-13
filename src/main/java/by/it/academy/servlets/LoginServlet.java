package by.it.academy.servlets;

import by.it.academy.entities.Role;
import by.it.academy.entities.User;
import by.it.academy.services.ServiceInstance;
import by.it.academy.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.it.academy.constants.Constants.*;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 10225548L;
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        HttpSession session = req.getSession();
        User user = userService.getUserDAO().read(login);
        if (isUserExist(user, login, password)) {
            session.setAttribute("role", user.getRole());
            session.setAttribute("login", user.getLogin());
            session.setAttribute("user", user);
            directToPage(req, resp, user);
        } else {
            req.getRequestDispatcher(WRONG_CREDENTIALS_ERROR).forward(req, resp);
        }
    }

    private boolean isUserExist(User user, String login, String password) {
        return user != null && user.getLogin().equals(login) && user.getPassword().equals(password);
    }

    private void directToPage(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
        if (user.getRole() == Role.ADMIN) {
            req.getRequestDispatcher(ADMIN_PAGE).forward(req, resp);
        } else {
            req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
    }

    @Override
    public void init() {
        userService = ServiceInstance.USER_SERVICE.getUserService();
    }
}
