package ua.edu.ucu.apps.flowerstore.user;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private UserRepository userRepository;
    public List<AppUser> getUsers() {
        return userRepository.findAll();
    }

    private void addUser(AppUser user) {
        if (!userRepository.findAppUserByEmail(user.getEmail()).isPresent()) {
            userRepository.save(user);
        }
    }
}
