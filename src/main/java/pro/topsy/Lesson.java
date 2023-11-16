package pro.topsy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 2, message = "5 chars min")
	private String name;

	private Date createdAt = new Date();
	
	@NotNull
	@Size(min = 1, message = "choose at least 1 exercise")
	@ManyToMany
	private List<Exercise> exercises = new ArrayList<>();
	
	public void addExercise(Exercise exercise) {
		this.exercises.add(exercise);
	}
}
