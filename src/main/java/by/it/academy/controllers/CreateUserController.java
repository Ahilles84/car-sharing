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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user/create"}, loadOnStartup = 0)
public class CreateUserController extends HttpServlet {
    private static final long serialVersionUID = 411848468446548L;
    private static final String USERS_LIST = "/user/read";
    private static final String REGISTRATION_PAGE = "/pages/user/registration_page.jsp";

    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        int age = Integer.parseInt(req.getParameter("age"));
        String newLogin = req.getParameter("login");
        String password = req.getParameter("password");
        UserType userType = UserType.valueOf(req.getParameter("userType"));
        userService.createUser(firstName, lastName, age, newLogin, password, userType);
        session.setAttribute("newLogin", newLogin);
        req.getRequestDispatcher(USERS_LIST).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(REGISTRATION_PAGE);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) {
        userService = UserServiceImpl.getUserService();
    }
}