package br.com.hadryan.tasksbackend.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends Exception {

    @Serial
    private static final long serialVersionUID = 1476542066938633226L;

    public ValidationException (String message) {
        super(message);
    }

}
