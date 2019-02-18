package springdemo.advice;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import springdemo.exceptions.StudentNotFoundException;
import springdemo.rest.StudentErrorResponse;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleStudentException(StudentNotFoundException ex){
		
		StudentErrorResponse response = new StudentErrorResponse();
		
		//Jackson responsible for converting this POJO in to JSON
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setMessage(ex.getMessage());
		response.setTimeStamp(Instant.now().toString());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	// Edge case exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {

		StudentErrorResponse response = new StudentErrorResponse();

		// Jackson responsible for converting this POJO in to JSON
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(ex.getMessage());
		response.setTimeStamp(Instant.now().toString());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
