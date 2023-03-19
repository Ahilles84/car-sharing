package by.it.academy.servlets;

import by.it.academy.entities.Car;
import by.it.academy.services.CarService;
import by.it.academy.services.ServiceInstance;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.constants.Constants.ADD_CAR_PAGE;

@WebServlet(urlPatterns = {"/car/create"})
public class AddCarServlet extends HttpServlet {
    private static final long serialVersionUID = 446548L;
    private CarService carService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String model = req.getParameter("model");
        String registrationNumber = req.getParameter("registrationNumber");
        Car car = new Car(model, registrationNumber);
        carService.getDAOInstance().create(car);
        req.getRequestDispatcher("/cars").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ADD_CAR_PAGE).forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) {
        carService = ServiceInstance.CAR_SERVICE.getCarService();
    }
}
