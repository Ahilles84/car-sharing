package by.it.academy.servlets;

import by.it.academy.entities.User;
import by.it.academy.services.ServiceInstance;
import by.it.academy.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.constants.Constants.MAIN_PAGE;
import static by.it.academy.constants.Constants.REGISTRATION_PAGE;

@WebServlet(urlPatterns = {"/user/create"})
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 8446548L;
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        int age = Integer.parseInt(req.getParameter("age"));
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(firstName, lastName, age, login, password);
        userService.getUserDAO().create(user);
        req.getRequestDispatcher(MAIN_PAGE).forward(req, resp);
    }

    @Override
    public void init() {
        userService = ServiceInstance.USER_SERVICE.getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
    }
}
