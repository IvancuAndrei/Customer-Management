package com.customerapp.customer_management_backend.entity.mappers;

import com.customerapp.customer_management_backend.entity.Customer;
import com.customerapp.customer_management_backend.entity.User;
import com.customerapp.customer_management_backend.entity.dto.CustomerDTO;
import com.customerapp.customer_management_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerMapper {

    private static UserRepository userRepository;


    public static CustomerDTO toCustomerDTO(Customer customer) {
        if(customer == null) {
            return null;
        }
        return new CustomerDTO(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone(), customer.getImageUrl(), customer.getUser().getId());
    }

    public static Customer toCustomer(CustomerDTO customerDTO) {
        if(customerDTO == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setImageUrl((customerDTO.getImageUrl() == null || customerDTO.getImageUrl().isEmpty()) ? "https://customer-management-images.s3.eu-north-1.amazonaws.com/profile_icon.jpg" : customerDTO.getImageUrl());
        Optional<User> user = userRepository.findById(customerDTO.getUserId());
        if(user.isPresent()){
            User user1 = user.get();
            customer.setUser(user1);
        }
        return customer;
    }
}
