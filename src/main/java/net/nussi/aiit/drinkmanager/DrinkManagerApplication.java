package net.nussi.aiit.drinkmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class DrinkManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrinkManagerApplication.class, args);
    }

}
