package pl.olawa.irvik.irvikProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ProductnotFoundException extends RuntimeException{


        private  static  final long serialVersionUID = 1L;

        public ProductnotFoundException(String message) {
            super(message);
        }

        public ProductnotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public ProductnotFoundException(Throwable cause) {
            super(cause);
        }
    }
