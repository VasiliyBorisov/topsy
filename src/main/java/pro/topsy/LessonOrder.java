package pro.topsy;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class LessonOrder {
	private String name;
	private String number;
	
	private List<Lesson> lessons = new ArrayList<>();
	
	public void addLesson(Lesson lesson) {
		this.lessons.add(lesson);
	}
}
