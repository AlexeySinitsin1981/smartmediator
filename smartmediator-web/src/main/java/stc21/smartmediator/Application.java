package stc21.smartmediator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import stc21.smartmediator.entity.FillEntity;

@SpringBootApplication
public class Application {

    @Autowired
    private FillEntity fillEntity;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        return args -> {
            System.out.println("Hello from Smart Mediator.");
            fillEntity.clearData();
            fillEntity.fillData();
        };
    }
}
