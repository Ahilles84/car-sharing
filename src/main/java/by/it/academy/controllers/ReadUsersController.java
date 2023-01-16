package by.it.academy.controllers;

import by.it.academy.entities.User;
import by.it.academy.repositories.UserRepositoryImpl;
import by.it.academy.services.UserServiceImpl;
import by.it.academy.services.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/user/read"})
public class ReadUsersController extends HttpServlet {
    private static final long serialVersionUID = 574523704572035L;
    private static final String USERS_PAGE = "/pages/user/users.jsp";
    private final UserService userService;

    public ReadUsersController() {
        this.userService = new UserServiceImpl(new UserRepositoryImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USERS_PAGE);
        List<User> users = userService.readUsers();
        req.setAttribute("users", users);
        requestDispatcher.forward(req, resp);
    }
}
