package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      Car car1 = new Car("bmv",1232);

      //userService.add(new User("User1", "Lastname1", "user1@mail.ru",car1));

      User user2 = userService.getUserWithCar(car1);

      System.out.println("Id = "+user2.getId());
      System.out.println("First Name = "+user2.getFirstName());
      System.out.println("Last Name = "+user2.getLastName());
      System.out.println("Email = "+user2.getEmail());
      System.out.println("Car = "+user2.getCar().getModel());
      System.out.println();




      context.close();
   }
}
