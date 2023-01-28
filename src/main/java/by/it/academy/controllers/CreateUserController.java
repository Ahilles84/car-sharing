package by.it.academy.controllers;

import by.it.academy.entities.UserType;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user/create"}, loadOnStartup = 0)
public class CreateUserController extends HttpServlet {
    private static final long serialVersionUID = 411848468446548L;
    private static final String USERS_PAGE = "/user/read";
    private static final String ADD_USER_PAGE = "/pages/user/add_user.jsp";

    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        int age = Integer.parseInt(req.getParameter("age"));
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserType userType = UserType.valueOf(req.getParameter("userType"));
        userService.createUser(firstName, lastName, age, login, password, userType);
        req.getRequestDispatcher(USERS_PAGE).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ADD_USER_PAGE);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }
}
