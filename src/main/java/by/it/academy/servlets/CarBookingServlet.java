package by.it.academy.servlets;

import by.it.academy.entities.Car;
import by.it.academy.services.CarService;
import by.it.academy.services.ServiceInstance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.constants.Constants.CAR_BUSY_ERROR_PAGE;

@WebServlet(urlPatterns = {"/car/booking"})
public class CarBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 714505178L;
    private CarService carService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Car car = carService.getDAOInstance().read(id);
        if (car.isBusy()) {
            req.getRequestDispatcher(CAR_BUSY_ERROR_PAGE).forward(req, resp);
        } else {
            carService.getDAOInstance().update(car);
            resp.sendRedirect("/cars");
        }
    }

    @Override
    public void init() {
        carService = ServiceInstance.CAR_SERVICE.getCarService();
    }
}
