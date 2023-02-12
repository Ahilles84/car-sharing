package by.it.academy.servlets;

import by.it.academy.dao.CarDAO;
import by.it.academy.entities.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/car/create"})
public class AddCarServlet extends HttpServlet {
    private static final long serialVersionUID = 446548L;
    private static final String ADD_CAR_PAGE = "/pages/car/add_car_page.jsp";
    private CarDAO carDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String model = req.getParameter("model");
        String registrationNumber = req.getParameter("registrationNumber");
        Car car = new Car(model, registrationNumber);
        carDAO.create(car);
        req.getRequestDispatcher("/cars").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ADD_CAR_PAGE);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) {
        carDAO = CarDAO.getCarDao();
    }
}
