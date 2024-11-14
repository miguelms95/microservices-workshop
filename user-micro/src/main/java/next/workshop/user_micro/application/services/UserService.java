package next.workshop.user_micro.application.services;

import next.workshop.user_micro.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUserById(Long id);
}
