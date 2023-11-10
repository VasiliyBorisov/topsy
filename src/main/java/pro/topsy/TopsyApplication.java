package pro.topsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class TopsyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopsyApplication.class, args);
	}
}

@Controller
class PsyHome {
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
