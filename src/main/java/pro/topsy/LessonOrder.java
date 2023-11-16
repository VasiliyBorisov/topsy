package pro.topsy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class LessonOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date placedAt = new Date();
	
	@NotBlank(message = "Name is required")
	private String name;

	@Pattern(regexp = "\\+[0-9]+\\([0-9]+\\)[0-9]+", message = "\\+[0-9]+\\([0-9]+\\)[0-9]+")
	private String number;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Lesson> lessons = new ArrayList<>();
	
	public void addLesson(Lesson lesson) {
		this.lessons.add(lesson);
	}
}
