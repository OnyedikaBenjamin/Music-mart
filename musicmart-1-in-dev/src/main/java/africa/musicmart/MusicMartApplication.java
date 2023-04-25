package africa.musicmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MusicMartApplication {
    public static void main(String[] args) {
        SpringApplication.run(MusicMartApplication.class, args);
    }

}