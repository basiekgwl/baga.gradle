package pl.bagagradle.test;


import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
@Builder
public class SimpleResponseMessage {

    HttpStatus status;

    String message;
}
