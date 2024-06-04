package com.dyplom.travel.services.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseUserDto {
    @NotBlank
    @Size(min = 5)
    private String username;
    @NotBlank
    @Size(min = 8)
    private String phone;
}
