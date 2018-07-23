package TV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"TV.*"})
@SpringBootApplication
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class);
    }

}
