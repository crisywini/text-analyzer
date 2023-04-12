package co.crisi.exception;

import co.crisi.SentimentNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SentimentNotFoundHandlerController {


    @ExceptionHandler(SentimentNotFoundException.class)
    public @ResponseBody
    ResponseEntity<String> handleSentimentNotFoundException(SentimentNotFoundException exception) {
        return ResponseEntity.notFound().header(HttpHeaders.WARNING, exception.getMessage()).build();
    }

}
