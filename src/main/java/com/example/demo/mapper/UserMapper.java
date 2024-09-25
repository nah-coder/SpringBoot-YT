package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.DTO.Request.UserDTO;
import com.example.demo.DTO.Reponse.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO userDTO);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserDTO userDTO);
}
