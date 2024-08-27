package ba.valera.springBoot.service;

import ba.valera.springBoot.model.User;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(int id);
    void save(User user);
    void update(User user, int id);
    void delete(int id);


}


