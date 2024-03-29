package by.it.academy.servlets;

import by.it.academy.dao.UserDAO;
import by.it.academy.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.it.academy.constants.Constants.USERS_LIST;

@WebServlet(urlPatterns = {"/users"})
public class ReadUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1028L;
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USERS_LIST);
        List<User> users = userDAO.readAll();
        req.setAttribute("users", users);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init() {
        userDAO = UserDAO.getUserDao();
    }
}
