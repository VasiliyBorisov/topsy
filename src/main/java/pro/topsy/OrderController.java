package pro.topsy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
//import pro.topsy.LessonOrder;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("lessonOrder")
public class OrderController {

	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(LessonOrder order, SessionStatus sessionStatus) {
		
		log.info(null);
		return "redirect:/";
	}
	
}
