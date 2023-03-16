package by.it.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CARS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {
    @Id
    @Column(name = "CAR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "NUMBER")
    private String registrationNumber;
    @Column(name = "STATUS")
    private boolean status;

    public Car(String model, String registrationNumber) {
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    public boolean isBusy() {
        return status;
    }
}
