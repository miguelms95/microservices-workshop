package next.workshop.user_micro.application.services;

import next.workshop.user_micro.domain.User;
import next.workshop.user_micro.infraestructure.api.exceptions.UserNotFoundException;
import next.workshop.user_micro.infraestructure.db.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}