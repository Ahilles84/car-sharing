package by.it.academy.controllers;

import by.it.academy.entities.Car;
import by.it.academy.repositories.CarRepositoryImpl;
import by.it.academy.services.CarServiceImpl;
import by.it.academy.services.CarService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/cars")
public class ReadCarsController extends HttpServlet {
    private static final String CARS_PAGE = "/pages/car/cars.jsp";
    private final CarService carService;

    public ReadCarsController() {
        this.carService = CarServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(CARS_PAGE);
        List<Car> cars = carService.showAllCars();
        req.setAttribute("cars", cars);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
