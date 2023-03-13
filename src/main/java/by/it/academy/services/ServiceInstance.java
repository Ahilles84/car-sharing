package by.it.academy.services;

public enum ServiceInstance {
    USER_SERVICE,
    CAR_SERVICE;
    final UserService userService = new UserService();
    final CarService carService = new CarService();

    public UserService getUserService() {
        return userService;
    }

    public CarService getCarService() {
        return carService;
    }
}
