package next.workshop.order_micro.infraestructure.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @GetMapping(value = "/")
    public String getHome() {
        logger.info("request - home \"/\"");
        return "{\"msg\":\"Hello world from ORDER micro!\"}";
    }

}
