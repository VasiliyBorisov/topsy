package pro.topsy;

import lombok.Data;

@Data
public class Exercise {
	private final String id;
	private final String name;
	private final Difficult diff;
	
	public enum Difficult {
		LOW, MEDIUM, HIGH
	}
}
