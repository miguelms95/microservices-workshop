package next.workshop.order_micro.infraestructure.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @GetMapping(value = "/")
    public String getHome() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        logger.info("request - order \"/\" at {}", LocalDateTime.now().format(formatter));
        return "{\"msg\":\"Hello world from ORDER micro!\"}";
    }

}
