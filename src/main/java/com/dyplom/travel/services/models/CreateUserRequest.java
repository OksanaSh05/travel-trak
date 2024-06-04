package com.dyplom.travel.services.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest extends BaseUserDto {
    @NotBlank
    @Size(min = 6)
    private String password;
}
