package pl.bagagradle.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {

    @NotNull
    @NonNull
    private User user;

}
