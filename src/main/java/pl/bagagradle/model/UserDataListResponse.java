package pl.bagagradle.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.List;


@Value
@Builder
public class UserDataListResponse {
    @NonNull
    List<User> users;

}
