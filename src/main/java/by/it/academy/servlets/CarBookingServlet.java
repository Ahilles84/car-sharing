package by.it.academy.servlets;

import by.it.academy.dao.CarDAO;
import by.it.academy.entities.Car;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/car/booking"})
public class CarBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 714505178L;
    private CarDAO carDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Car car = carDAO.read(id);
        carDAO.update(car);
        resp.sendRedirect("/cars");
    }

    @Override
    public void init() {
        carDAO = CarDAO.getCarDao();
    }
}
