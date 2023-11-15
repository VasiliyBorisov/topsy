package pro.topsy;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExerciseConverter implements Converter<String, Exercise>{
	
	private ExerciseRepository exRepo;
//	@Autowired
	public ExerciseConverter (ExerciseRepository exRepo) {
		this.exRepo = exRepo;
	}

	@Override
	public Exercise convert(String id) {
		return exRepo.findById(id).orElse(null);
	}
	
}
