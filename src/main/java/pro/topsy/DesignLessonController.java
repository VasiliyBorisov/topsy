package pro.topsy;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import pro.topsy.Exercise.Difficult;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("lessonOrder")
public class DesignLessonController {
	
	private final ExerciseRepository exRepo;
//	@Autowired
	public DesignLessonController (ExerciseRepository exRepo) {
		this.exRepo = exRepo;
	}
	
	@ModelAttribute
	public void addExercisesToModel(Model model) {
		List<Exercise> exercises = (List<Exercise>) exRepo.findAll();
		Difficult[] difficults = Difficult.values();
		
		for (Difficult diff : difficults) {
			model.addAttribute(diff.toString().toLowerCase(), filterByDiff(exercises, diff));
		}
	}

	private Iterable<Exercise> filterByDiff (List<Exercise> exercises, Difficult diff) {
		return exercises.stream()
				.filter(x -> x.getDiff().equals(diff))
				.collect(Collectors.toList());
	}
	
	@ModelAttribute(name = "lessonOrder")
	public LessonOrder order() {
		return new LessonOrder();
	}
	
	@ModelAttribute(name = "lesson")
	public Lesson lesson() {
		Lesson l = new Lesson();
		log.info("new Lesson: {}", l);
		return l;
	}
	
	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	@PostMapping
	public String processLesson(@Valid Lesson lesson, Errors errors, @ModelAttribute LessonOrder lessonOrder) {
		if (errors.hasErrors()) {
			return "design";
		}
		lessonOrder.addLesson(lesson);
		log.info("Processing lesson: {}", lesson);
		log.info("lessonOrder: {}", lessonOrder);
		return "redirect:/orders/current";
	}
}
