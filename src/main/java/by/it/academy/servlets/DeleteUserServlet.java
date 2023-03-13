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

import static by.it.academy.constants.Constants.DELETE_USER_PAGE;
import static by.it.academy.constants.Constants.USER_NOT_FOUND_ERROR;

@WebServlet(urlPatterns = {"/user/delete"})
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 548L;
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("Login");
        User user = userService.getUserDAO().read(login);
        if (isUserExist(user, login)) {
            userService.getUserDAO().delete(user);
            resp.sendRedirect("/users");
        } else {
            req.getRequestDispatcher(USER_NOT_FOUND_ERROR).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(DELETE_USER_PAGE).forward(req, resp);
    }

    private boolean isUserExist(User user, String login) {
        return user != null && user.getLogin().equals(login);
    }

    @Override
    public void init() {
        userService = ServiceInstance.USER_SERVICE.getUserService();
    }
}
