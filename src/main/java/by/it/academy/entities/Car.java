package by.it.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int id;
    private String model;
    private String registrationNumber;
    private boolean status;

    public Car(String model, String registrationNumber) {
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    public void rentCar() {
        this.status = true;
    }

    public boolean isBusy() {
        return status;
    }
}
