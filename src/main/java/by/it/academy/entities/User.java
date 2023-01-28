package by.it.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String firstName;
  private String lastName;
  private int age;
  private String login;
  private String password;
  private UserType userType;
}
