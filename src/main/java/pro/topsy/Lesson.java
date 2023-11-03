package pro.topsy;

import java.util.List;

import lombok.Data;

@Data
public class Lesson {
	private String name;
	private List<Exercise> exercises; 
}
