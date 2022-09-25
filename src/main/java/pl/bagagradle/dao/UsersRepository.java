package pl.bagagradle.dao;


import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    @NonNull Optional<UserEntity> findById(@NonNull Long id);

    List<UserEntity> findByFirstName(String name);

}