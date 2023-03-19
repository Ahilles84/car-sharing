package by.it.academy.servlets;

import by.it.academy.entities.Car;
import by.it.academy.entities.User;
import by.it.academy.services.CarService;
import by.it.academy.services.ServiceInstance;
import by.it.academy.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.it.academy.constants.Constants.DELETE_USER_PAGE;
import static by.it.academy.constants.Constants.USER_NOT_FOUND_ERROR;

@WebServlet(urlPatterns = {"/user/delete"})
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 548L;
    private UserService userService;
    private CarService carService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("Login");
        User user = userService.getDAOInstance().read(login);
        releaseRentedCar(user);
        if (isUserExist(user, login)) {
            userService.getDAOInstance().delete(user);
            resp.sendRedirect("/users");
        } else {
            req.getRequestDispatcher(USER_NOT_FOUND_ERROR).forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(DELETE_USER_PAGE).forward(req, resp);
    }

    private boolean isUserExist(User user, String login) {
        return user != null && user.getLogin().equals(login);
    }

    private void releaseRentedCar(User user) {
        List<Car> cars = carService.getDAOInstance().readAll();
        for (Car car : cars) {
            if (car.getUser() != null && car.getUser().getId() == user.getId()) {
                carService.getDAOInstance().releaseCar(car);
            }
        }
    }

    @Override
    public void init() {
        userService = ServiceInstance.USER_SERVICE.getUserService();
        carService = ServiceInstance.CAR_SERVICE.getCarService();
    }
}
