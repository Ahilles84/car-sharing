package by.it.academy.servlets;

import by.it.academy.dao.CarDAO;
import by.it.academy.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/car/booking"})
public class CarBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 714505178L;
    private CarDAO carDAO;
    private UserDAO userDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        carDAO = CarDAO.getCarDao();
        userDAO = UserDAO.getUserDao();
    }
}
