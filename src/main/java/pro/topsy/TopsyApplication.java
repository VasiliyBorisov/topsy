package pro.topsy;

import java.nio.charset.StandardCharsets;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.common.hash.Hashing;

import pro.topsy.Exercise.Difficult;

@SpringBootApplication
public class TopsyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopsyApplication.class, args);
	}
	
	@Bean
	CommandLineRunner dataLoader(ExerciseRepository repo) {
		return args -> {
			for (int i=0; i<10; i++) {
				repo.save(new Exercise(Integer.toString(i), Hashing.sha256().hashInt(i).toString(), Difficult.getRandom()));
				
			}
		};
	}
	
}

@Controller
class PsyHome {
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
