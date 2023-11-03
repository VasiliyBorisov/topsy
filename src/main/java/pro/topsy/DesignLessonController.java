package pro.topsy;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import pro.topsy.Exercise.Difficult;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("lessonOrder")
public class DesignLessonController {
	
	@ModelAttribute
	public void addExercisesToModel(Model model) {
	
		List<Exercise> exercises = Arrays.asList(
				new Exercise("aaa", "aa aa aa", Difficult.HIGH),
				new Exercise("bbb", "bb bb bb", Difficult.HIGH),
				new Exercise("ccc", "cc cc cc", Difficult.LOW),
				new Exercise("ddd", "dd dd dd", Difficult.MEDIUM),
				new Exercise("eee", "ee ee ee", Difficult.MEDIUM),
				new Exercise("fff", "ff ff ff", Difficult.HIGH)
				);
//		model.addAllAttributes(exercises);
		String str = exercises.getClass().getSuperclass().toString();
		model.addAttribute(str);
		model.addAttribute(exercises);
	}
	
	@ModelAttribute(name = "lessonOrder")
	public LessonOrder order() {
		return new LessonOrder();
	}
	
	@ModelAttribute(name = "lesson")
	public Lesson lesson() {
		return new Lesson();
	}
	
	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	@PostMapping
	public String processLesson(Lesson lesson, @ModelAttribute LessonOrder lessonOrder) {
		lessonOrder.addLesson(lesson);
		log.info("Processing lesson: {}", lesson);
		return "redirect:/orders/current";
	}
}
