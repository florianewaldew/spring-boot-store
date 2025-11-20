package com.codewithmosh.store.users;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UpdateUserRequest {

    private Long id;
    @NotEmpty(message = "name must be provided")
    private String name;
    @NotEmpty(message = "email must be provided")
    private String email;
}
