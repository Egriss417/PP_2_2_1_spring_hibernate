package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = context.getBean(Car.class,"bmv",1232);
      Car car2 = context.getBean(Car.class,"audi",234521);

      userService.add(context.getBean(User.class,"User1", "Lastname1", "user1@mail.ru",car1));
      userService.add(context.getBean(User.class,"User2", "Lastname2", "user2@mail.ru",car2));

      User user = userService.getUserWithCar(car1);

      System.out.println(user);

      context.close();
   }
}
