package tpe.scooterMS.exception;


import java.util.HashMap;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
	
	@ExceptionHandler(DisabledUserException.class)
	public ResponseEntity<String> handleDisabledUserException(DisabledUserException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(NotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ScooterNotLocatedAtStopException.class)
	public ResponseEntity<String> handleScooterNotLocatedAtStopException(ScooterNotLocatedAtStopException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ScooterUnavailableException.class)
	public ResponseEntity<String> handleScooterUnavailableException(ScooterUnavailableException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TripAlreadyEndedException.class)
	public ResponseEntity<String> handleTripAlreadyEndedException(TripAlreadyEndedException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TripInPauseException.class)
	public ResponseEntity<String> handleTripInPauseException(TripInPauseException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TripNotPausedException.class)
	public ResponseEntity<String> handleTripNotPausedException(TripNotPausedException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TripReachedPauseTimeLimitException.class)
	public ResponseEntity<String> handleTripReachedPauseTimeLimitException(TripReachedPauseTimeLimitException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserOnTripException.class)
	public ResponseEntity<String> handleUserOnTripException(UserOnTripException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccountWithoutMoneyException.class)
	public ResponseEntity<String> handleAccountWithoutMoneyException(AccountWithoutMoneyException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String, String>> handleinvalidArgument(MethodArgumentNotValidException exception) {
		HashMap<String, String> errors = new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PropertyValueException.class)
	public ResponseEntity<String> handlePropertyValueException(PropertyValueException exception) {
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
