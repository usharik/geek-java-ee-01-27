package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @EJB
    private UserRepository userRepository;

    @TransactionAttribute
    public void saveOrUpdate(UserRepr user) {
        User saved = userRepository.saveOrUpdate(new User(user));
        user.setId(saved.getId());
    }

    @TransactionAttribute
    public void delete(int id) {
        userRepository.delete(id);
    }

    @TransactionAttribute
    public UserRepr findById(int id) {
        return new UserRepr(userRepository.findById(id));
    }

    @TransactionAttribute
    public boolean existsById(int id) {
        return userRepository.findById(id) != null;
    }

    @TransactionAttribute
    public List<UserRepr> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(UserRepr::new)
                .collect(Collectors.toList());
    }

}
