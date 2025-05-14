package com.funkymonk.stradew_valley_crop_api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CropNotFoundAdvice {
    @ExceptionHandler(CropNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(CropNotFoundException ex) {
        return ex.getMessage();
    }

}
