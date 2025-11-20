package com.codewithmosh.store.users;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdatePasswordRequest {

    private Long id;
    @NotBlank(message = "oldPassword must be provided")
    private String oldPassword;
    @NotBlank(message = "newPassword must be provided")
    private String newPassword;
}
