package pl.bagagradle.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bagagradle.access.MyPaths;
import pl.bagagradle.service.NewServiceCar;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(MyPaths.MY_APP)
@RequiredArgsConstructor
public class HelloWorldController {

    private final NewServiceCar serviceCar;

    @GetMapping(path = MyPaths.HELLO_WORLD,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponseMessage> myFirstMessage() {
        return ResponseEntity.accepted().body(serviceCar.getMessage());
    }

    @GetMapping(path = MyPaths.WELCOME,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponseMessage> mySecondMessage(@NotNull @RequestParam(name = "name") String name) {
        return ResponseEntity.accepted().body(serviceCar.setName(name));
    }

}
