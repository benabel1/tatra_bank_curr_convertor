package controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RateRecordNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(RateRecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    String employeeNotFoundHandler(RateRecordNotFoundException ex) {
        return ex.getMessage();
    }
}
