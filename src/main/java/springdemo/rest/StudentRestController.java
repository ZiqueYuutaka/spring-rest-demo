package springdemo.rest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springdemo.entity.Student;
import springdemo.exceptions.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	//@PostConstruct loads data once when the controller bean is created
	@PostConstruct
	public void loadData(){
		students = new ArrayList<>();
		students.add(new Student("hello", "world"));
		students.add(new Student("Jonathan", "Haidt"));
		students.add(new Student("Jill", "Smith"));
	}

	@GetMapping("/students")
	public List<Student> getAllStudents(){		
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getSingleStudent(@PathVariable int studentId)throws StudentNotFoundException{
		if(studentId >= students.size() || studentId < 0){
			throw new StudentNotFoundException("student not found at " + studentId);
		}
		return students.get(studentId);
	}
	
	/////	EXCEPTION HANDLING	///////////////////////////////////////////////////////////
	
	//Moved to StudentRestExceptionHandler for best practices
	//@ExceptionHandler
	//public ResponseEntity<StudentErrorResponse> handleStudentException(StudentNotFoundException ex){
	//	
	//	StudentErrorResponse response = new StudentErrorResponse();
	//	
	//	//Jackson responsible for converting this POJO in to JSON
	//	response.setStatus(HttpStatus.NOT_FOUND.value());
	//	response.setMessage(ex.getMessage());
	//	response.setTimeStamp(Instant.now().toString());
	//	
	//	return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	//}
	
	////Edge case exception handler
	//Moved to StudentRestExceptionHandler
	//@ExceptionHandler
	//public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
	//	
	//	StudentErrorResponse response = new StudentErrorResponse();
	//	
	//	//Jackson responsible for converting this POJO in to JSON
	//	response.setStatus(HttpStatus.BAD_REQUEST.value());
	//	response.setMessage(ex.getMessage());
	//	response.setTimeStamp(Instant.now().toString());
	//	
	//	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	//}
}
