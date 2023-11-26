package edu.lab8.user;

import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private UserRepository userRepository;
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    void addUser(User user) {
        if (!userRepository.findAppUserByEmail(((AppUser) user).getEmail()).isPresent()) {
            userRepository.save(user);
        }
    }

    void deleteUser(Integer id) {
        boolean exists = userRepository.existsById(id);
        if (exists) {
            userRepository.deleteById(id);
        }
    }
}
