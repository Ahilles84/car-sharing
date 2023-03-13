package by.it.academy.servlets;

import by.it.academy.constants.Constants;
import by.it.academy.entities.Car;
import by.it.academy.services.CarService;
import by.it.academy.services.ServiceInstance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/car/booking"})
public class CarBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 714505178L;
    private CarService carService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Car car = carService.getCarDAO().read(id);
        if (car.isBusy()) {
            req.getRequestDispatcher(Constants.CAR_BUSY_ERROR_PAGE).forward(req, resp);
        } else {
            carService.getCarDAO().update(car);
            resp.sendRedirect("/cars");
        }
    }

    @Override
    public void init() {
        carService = ServiceInstance.CAR_SERVICE.getCarService();
    }
}
