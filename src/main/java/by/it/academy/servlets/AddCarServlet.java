package by.it.academy.servlets;

import by.it.academy.dao.CarDAO;
import by.it.academy.entities.Car;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static by.it.academy.constants.Constants.ADD_CAR_PAGE;
import static by.it.academy.constants.Constants.CARS_LIST;

@WebServlet(urlPatterns = {"/car/create"})
public class AddCarServlet extends HttpServlet {
    private static final long serialVersionUID = 446548L;
    private CarDAO carDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String model = req.getParameter("model");
        String registrationNumber = req.getParameter("registrationNumber");
        Car car = new Car(model, registrationNumber);
        carDAO.create(car);
        req.getRequestDispatcher(CARS_LIST).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ADD_CAR_PAGE).forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) {
        carDAO = CarDAO.getCarDao();
    }
}
