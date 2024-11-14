package next.workshop.user_micro.infraestructure.db;

import next.workshop.user_micro.domain.User;
import next.workshop.user_micro.infraestructure.api.exceptions.UserNotFoundException;

import java.util.List;

public interface UserRepository {
    User findById(Long id) throws UserNotFoundException;
    List<User> findAll();
}
