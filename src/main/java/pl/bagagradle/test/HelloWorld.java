package pl.bagagradle.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bagagradle.access.MyPaths;
import pl.bagagradle.service.NewServiceCar;

@RestController
@RequestMapping(MyPaths.MY_APP)
@RequiredArgsConstructor
public class HelloWorld {

    private final NewServiceCar serviceCar;

    @GetMapping(path = MyPaths.HELLO_WORLD,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponseMessage> myFirstMessage() {
        return ResponseEntity.accepted().body(serviceCar.getMessage());
    }

}
