package by.it.academy.servlets;

import by.it.academy.dao.UserDAO;
import by.it.academy.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 10225548L;
    private static final String LOGIN_PAGE = "/pages/user/login_page.jsp";
    private static final String USER_NOT_FOUND = "/pages/errors/wrong_credentials.jsp";
    private UserDAO userDAO;
    private String login;
    private String password;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login = req.getParameter("login");
        password = req.getParameter("password");
        HttpSession session = req.getSession();
        if (isUserExist(login)) {
            User user = userDAO.read(login);
            session.setAttribute("userType", user.getUserType());
            session.setAttribute("login", user.getLogin());
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher(USER_NOT_FOUND).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(LOGIN_PAGE);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) {
        userDAO = UserDAO.getUserDao();
    }

    private boolean isUserExist(String login) {
        User user = userDAO.read(login);
        return user.getLogin().equals(this.login) && user.getPassword().equals(this.password);
    }
}
