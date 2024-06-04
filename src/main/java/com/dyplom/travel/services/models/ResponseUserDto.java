package com.dyplom.travel.services.models;

import com.dyplom.travel.models.user.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUserDto extends BaseUserDto {
    private String id;
    private String token;
    @JsonIgnore
    private UserRole role;
}
