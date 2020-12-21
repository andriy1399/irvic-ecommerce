package pl.olawa.irvik.irvikProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ProductRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponce> handleException(ProductnotFoundException exception){
        ProductErrorResponce errorResponce = new ProductErrorResponce();
        errorResponce.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponce.setMessage(errorResponce.getMessage());
        errorResponce.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(errorResponce, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponce> handleException(Exception exception){
        ProductErrorResponce errorResponce = new ProductErrorResponce();

        errorResponce.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponce.setMessage(errorResponce.getMessage());
        errorResponce.setTimeStamp(System.currentTimeMillis());

        return  new ResponseEntity<>(errorResponce, HttpStatus.NOT_FOUND);
    }


}
