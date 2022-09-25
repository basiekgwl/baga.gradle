package pl.bagagradle.model;

import lombok.Builder;
import lombok.Value;
import org.springframework.lang.Nullable;

@Value
@Builder
public class UserDataResponse {

    @Nullable
    User user;

}
