package pl.bagagradle.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    private String id;

    @NotNull
    @NonNull
    private String firstName;

    @NotNull
    @NonNull
    private String lastName;

    @Nullable
    private String address;

    @Nullable
    private String personalId;

}
