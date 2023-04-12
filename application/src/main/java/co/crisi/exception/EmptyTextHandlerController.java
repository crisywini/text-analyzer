package co.crisi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class EmptyTextHandlerController {

    @ExceptionHandler(EmptyTextException.class)
    public @ResponseBody
    ResponseEntity<String> handleEmptyTextException(EmptyTextException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
