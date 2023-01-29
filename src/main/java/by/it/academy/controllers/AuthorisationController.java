package by.it.academy.controllers;

import by.it.academy.entities.User;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/login"})
public class AuthorisationController extends HttpServlet {
    private static final long serialVersionUID = 1023446025548L;
    private static final String LOGIN_PAGE = "/pages/user/login_page.jsp";
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        List<User> users = userService.readUsers();
        HttpSession session = req.getSession();
        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())){
                session.setAttribute(user.getLogin(), user.getUserType());
                req.getRequestDispatcher("/index.html").forward(req, resp);
            } else {
                req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(LOGIN_PAGE);
        requestDispatcher.forward(req, resp);
    }
    @Override
    public void init(ServletConfig config) {
        userService = UserServiceImpl.getUserService();
    }
}
