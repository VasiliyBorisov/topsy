package pro.topsy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pro.topsy.Exercise.Difficult;

@Component
public class ExerciseConverter implements Converter<String, Exercise>{
	
	private ExerciseRepository exRepo;
	@Autowired
	public ExerciseConverter (ExerciseRepository exRepo) {
		this.exRepo = exRepo;
	}
	
//	private Map<String, Exercise> exerciseMap = new HashMap<>();
//	public ExerciseConverter() {
//		exerciseMap.put("aaa", new Exercise("aaa", "aa aa aa", Difficult.HIGH));
//		exerciseMap.put("bbb", new Exercise("bbb", "bb bb bb", Difficult.HIGH));
//		exerciseMap.put("ccc", new Exercise("ccc", "cc cc cc", Difficult.LOW));
//		exerciseMap.put("ddd", new Exercise("ddd", "dd dd dd", Difficult.MEDIUM));
//		exerciseMap.put("eee", new Exercise("eee", "ee ee ee", Difficult.MEDIUM));
//		exerciseMap.put("fff", new Exercise("fff", "ff ff ff", Difficult.HIGH));
//	}
	
	@Override
	public Exercise convert(String id) {
//		return exerciseMap.get(id);
		return exRepo.findById(id).orElse(null);
	}
	
}
