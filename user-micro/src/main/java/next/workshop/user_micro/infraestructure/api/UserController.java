package next.workshop.user_micro.infraestructure.api;

import next.workshop.user_micro.application.services.UserService;
import next.workshop.user_micro.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @GetMapping(value = "/")
    public String getHome() {
        logger.info("request - home \"/\"");
        return "{\"msg\":\"Hello world from USER micro!\"}";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        logger.info("request - getUsers at {}", LocalDateTime.now().format(formatter));
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id) {
        logger.info("request - getUserById {} at {}", id, LocalDateTime.now().format(formatter));
        return userService.getUserById(Long.parseLong(id));
    }

}
