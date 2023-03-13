package by.it.academy.servlets;

import by.it.academy.entities.Car;
import by.it.academy.services.CarService;
import by.it.academy.services.ServiceInstance;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.it.academy.constants.Constants.CARS_LIST;

@WebServlet(urlPatterns = {"/cars"})
public class ReadCarsServlet extends HttpServlet {
    private static final long serialVersionUID = 98L;
    private CarService carService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CARS_LIST);
        List<Car> cars = carService.getCarDAO().readAll();
        req.setAttribute("cars", cars);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init() {
        carService = ServiceInstance.CAR_SERVICE.getCarService();
    }
}
