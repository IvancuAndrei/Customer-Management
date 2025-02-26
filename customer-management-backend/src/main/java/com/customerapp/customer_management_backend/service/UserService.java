package com.customerapp.customer_management_backend.service;

import com.customerapp.customer_management_backend.entity.User;
import com.customerapp.customer_management_backend.dto.UserDTO;

public interface UserService {

    User createUser(UserDTO userDTO);
    User getUserById(Long id);
    void deleteUser(Long id);
    User updateUser(Long id, UserDTO userDTO);
}
