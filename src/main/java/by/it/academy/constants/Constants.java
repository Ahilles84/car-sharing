package by.it.academy.constants;

import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Constants {
    public static final String MAIN_PAGE = "/index.jsp";
    public static final String ADD_CAR_PAGE = "/pages/car/add_car_page.jsp";
    public static final String CARS_LIST = "/pages/car/cars_list.jsp";
    public static final String USERS_LIST = "/pages/user/users_list.jsp";
    public static final String REGISTRATION_PAGE = "/pages/user/registration_page.jsp";
    public static final String LOGIN_PAGE = "/pages/user/login_page.jsp";
    public static final String ADMIN_PAGE = "/pages/admin/admin_page.jsp";
    public static final String USER_NOT_FOUND_ERROR_PAGE = "/pages/errors/wrong_credentials.jsp";
    public static final String LOGIN_EXISTS_ERROR_PAGE = "/pages/errors/login_exists.jsp";
    public static final String CAR_BUSY_ERROR_PAGE = "/pages/errors/car_is_busy.jsp";
    public static final EntityManager entityManager = JPAUtil.getEntityManager();
    public static final EntityTransaction transaction = entityManager.getTransaction();
}
