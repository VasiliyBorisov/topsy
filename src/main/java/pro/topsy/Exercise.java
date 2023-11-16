package pro.topsy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
//@RequiredArgsConstructor
public class Exercise {
	@Id
	private final String id;
	private final String name;
	private final Difficult diff;
	
	public enum Difficult {
		LOW, MEDIUM, HIGH;
		
		public static Difficult getRandom() {
			return values()[(int) (Math.random() * values().length)];
		}
		
	}
}
