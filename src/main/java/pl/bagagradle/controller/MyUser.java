package pl.bagagradle.controller;

import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bagagradle.access.MyPaths;
import pl.bagagradle.model.CreateUserRequest;
import pl.bagagradle.model.SaveUserResponse;
import pl.bagagradle.model.UserDataListResponse;
import pl.bagagradle.test.SimpleResponseMessage;

import javax.validation.constraints.NotNull;

public interface MyUser {


    @GetMapping(path = MyPaths.HELLO_WORLD,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SimpleResponseMessage> myFirstMessage();

    @GetMapping(path = MyPaths.WELCOME,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SimpleResponseMessage> mySecondMessage(@NotNull @RequestParam(name = "name") String name);

    @GetMapping(path = MyPaths.GET_USERS,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserDataListResponse> getUserList();

    @PostMapping(path = MyPaths.SAVE_USER,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SaveUserResponse> saveUser(@RequestBody @NonNull CreateUserRequest request);

}
