package com.dyplom.travel.services.mappers;

import com.dyplom.travel.models.user.User;
import com.dyplom.travel.services.models.ResponseUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User asUser(String username, String password, String phone);

    ResponseUserDto asResponse(User user);
}
