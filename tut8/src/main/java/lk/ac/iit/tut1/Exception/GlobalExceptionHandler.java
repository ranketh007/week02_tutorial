package lk.ac.iit.tut1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ApiError> handleProductNotFoundException(ProductNotFoundException ex){
      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body(new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }
}
