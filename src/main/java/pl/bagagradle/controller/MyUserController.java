package pl.bagagradle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bagagradle.access.MyPaths;
import pl.bagagradle.model.CreateUserRequest;
import pl.bagagradle.model.SaveUserResponse;
import pl.bagagradle.model.UserDataListResponse;
import pl.bagagradle.service.NewServiceUser;
import pl.bagagradle.test.SimpleResponseMessage;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(MyPaths.MY_APP)
@RequiredArgsConstructor
public class MyUserController implements MyUser {

    private final NewServiceUser service;

    @Override
    public ResponseEntity<SimpleResponseMessage> myFirstMessage() {
        return ResponseEntity.accepted().body(service.getMessage());
    }

    @Override
    public ResponseEntity<SimpleResponseMessage> mySecondMessage(@NotNull @RequestParam(name = "name") String name) {
        return ResponseEntity.accepted().body(service.setName(name));
    }

    @Override
    public ResponseEntity<UserDataListResponse> getUserList() {
        return ResponseEntity.ok().body(service.getUsers());
    }

    @Override
    public ResponseEntity<SaveUserResponse> saveUser(CreateUserRequest request) {
        return ResponseEntity.ok(service.addNewUser(request));
    }

}
