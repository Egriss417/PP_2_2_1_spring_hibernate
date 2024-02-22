package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   @Autowired
   private SessionFactory sessionFactory;
   @Transactional
   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      try (Session session = sessionFactory.openSession()) {
         String hql = "FROM User";
         TypedQuery<User> query = session.createQuery(hql, User.class);
         return query.getResultList();
      }
   }

   @Override
   public User getUserWithCar(Car car) {
      try (Session session = sessionFactory.openSession()) {
         String hql = "SELECT u FROM User u WHERE u.car.model = :model AND u.car.series = :series";
         Query query = session.createQuery(hql, User.class)
                 .setParameter("series", car.getSeries())
                 .setParameter("model", car.getModel());
         return (User) query.getSingleResult();
      }
   }

}
