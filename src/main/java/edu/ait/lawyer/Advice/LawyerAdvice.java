package edu.ait.lawyer.Advice;

import edu.ait.lawyer.dto.ResponseBody.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class LawyerAdvice {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseBody handleExceptions(SQLIntegrityConstraintViolationException e) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.addResponse("error", "This Mail has used earlier. Please use another mail.");
        return responseBody;
    }
}
