package pl.bagagradle.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.bagagradle.dao.UserEntity;
import pl.bagagradle.dao.UsersRepository;
import pl.bagagradle.model.*;
import pl.bagagradle.test.SimpleResponseMessage;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewServiceUser {

    private final UsersRepository repository;

    private final SaveUserService saveUserService;

    @NonNull
    public SimpleResponseMessage getMessage() {
        return SimpleResponseMessage.builder().status(HttpStatus.ACCEPTED).message("Hello Baga!!!").build();
    }

    @NonNull
    public SimpleResponseMessage setName(@NonNull String name) {
        return SimpleResponseMessage.builder().status(HttpStatus.ACCEPTED).message(String.format("Hello %s!!!", name)).build();
    }

    @NonNull
    public SaveUserResponse addNewUser(@NonNull CreateUserRequest request) {
        return SaveUserResponse.builder()
                .id(saveUserService.addNewUser(request))
                .build();
    }

    @NonNull
    public UserDataResponse getUserDataById(@NonNull String userId) {
        Optional<UserEntity> entity = repository.findById(Long.getLong(userId));
        return entity.map(NewServiceUser::createUserResponse).orElse(noUserResponse());
    }


    @NonNull
    public UserDataListResponse getUsers() {
        List<UserEntity> entityList = repository.findAll();

        List<User> users = entityList.stream().filter(Objects::nonNull).map(NewServiceUser::buildUser).collect(Collectors.toList());
        return UserDataListResponse.builder()
                .users(users)
                .build();
    }

    private static UserDataResponse createUserResponse(@NonNull UserEntity userEntity) {
        return UserDataResponse.builder()
                .user(buildUser(userEntity))
                .build();
    }

    private static User buildUser(@NonNull UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId().toString())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .address(userEntity.getAddress())
                .personalId(userEntity.getPersonalId())
                .build();
    }

    private static UserDataResponse noUserResponse() {
        return UserDataResponse.builder()
                .build();
    }


}
