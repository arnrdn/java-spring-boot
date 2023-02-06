package ru.katacademy.springbootuser.DAO;

import org.springframework.stereotype.Component;
import ru.katacademy.springbootuser.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void updateUser(User user) {
        System.out.println(user.toString());
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        User user = findById(id);

        if (user == null) {
            throw new NullPointerException("User not found");
        }

        entityManager.remove(user);
        entityManager.flush();
    }
}