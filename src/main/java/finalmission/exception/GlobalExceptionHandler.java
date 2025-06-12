package finalmission.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NotFoundDateTimeException.class)
    public ResponseEntity<String> handleException(NotFoundDateTimeException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}
