package pro.topsy;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
//import pro.topsy.LessonOrder;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("lessonOrder")
public class OrderController {

	private final OrderRepository oRepo;
	public OrderController (OrderRepository oRepo) {
		this.oRepo = oRepo;
	}
	
	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(@Valid LessonOrder order, Errors errors, SessionStatus sessionStatus) {
		if (errors.hasErrors()) {
			return "orderForm";
		}
		oRepo.save(order);
		
		log.info("Order submited {}", order);
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
}
