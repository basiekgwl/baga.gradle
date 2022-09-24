package pl.bagagradle.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.bagagradle.test.SimpleResponseMessage;

@Service
public class NewServiceCar {

     public SimpleResponseMessage getMessage() {
         return SimpleResponseMessage.builder().status(HttpStatus.ACCEPTED).message("Hello Baga!!!").build();
     }

}
