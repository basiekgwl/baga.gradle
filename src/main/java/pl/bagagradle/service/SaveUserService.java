package pl.bagagradle.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bagagradle.dao.UserEntity;
import pl.bagagradle.dao.UsersRepository;
import pl.bagagradle.model.CreateUserRequest;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class SaveUserService {

    private final UsersRepository repository;

    public String addNewUser(@NonNull CreateUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setFirstName(request.getUser().getFirstName());
        entity.setLastName(request.getUser().getLastName());
        entity.setAddress(request.getUser().getAddress());
        entity.setPersonalId(request.getUser().getPersonalId());
        repository.save(entity);
        return Optional.ofNullable(entity.getId()).map(Object::toString).orElse("UNKNOWN USER ID");
    }
}
