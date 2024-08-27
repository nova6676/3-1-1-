package ba.valera.springBoot.dao;


import ba.valera.springBoot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void removeUserById(long id);

    List<User> findAll();
    Optional<User> findById(int id);

    List<User> getAllUsers();

    User getUserById(long id);

    void save(User user);
    void update(User user, int id);
    void delete(int id);

    void update(User updateUser);
}
