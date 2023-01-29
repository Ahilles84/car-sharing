package by.it.academy.controllers;

import by.it.academy.services.CarService;
import by.it.academy.services.CarServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/car/create"})
public class CreateCarController extends HttpServlet {
    private static final long serialVersionUID = 902168446548L;
    private static final String ADD_CAR_PAGE = "/pages/car/add_car_page.jsp";

    private CarService carService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String model = req.getParameter("model");
        String registrationNumber = req.getParameter("registrationNumber");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        carService.addCar(model, registrationNumber, status);
        req.getRequestDispatcher("/cars").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ADD_CAR_PAGE);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        carService = CarServiceImpl.getInstance();
    }
}
