package com.customerapp.customer_management_backend.entity.mappers;

import com.customerapp.customer_management_backend.entity.dto.UserDTO;
import com.customerapp.customer_management_backend.entity.User;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        if(user == null) {
            return null;
        }
        return new UserDTO(user.getUsername(), user.getPassword(), user.getEmail());
    }

    public static User toUser(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
