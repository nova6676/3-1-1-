package ba.valera.springBoot.service;


import ba.valera.springBoot.dao.UserDao;
import ba.valera.springBoot.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public Optional<User> findById(int id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(User user, int id) {
        userDao.update(user, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
//  все парвильно запускаеться коммент для себя что бы еще не сойти с ума больше
