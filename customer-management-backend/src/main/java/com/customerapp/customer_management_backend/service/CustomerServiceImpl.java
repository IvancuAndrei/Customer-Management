package com.customerapp.customer_management_backend.service;

import com.customerapp.customer_management_backend.dto.CustomerDTO;
import com.customerapp.customer_management_backend.entity.Customer;
import com.customerapp.customer_management_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.setImageUrl((customerDTO.getImageUrl() == null || customerDTO.getImageUrl().isEmpty()) ? "https://customer-management-images.s3.eu-north-1.amazonaws.com/profile_icon.jpg" : customerDTO.getImageUrl());
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setFirstName(customerDTO.getFirstName());
            customer.setLastName(customerDTO.getLastName());
            customer.setEmail(customerDTO.getEmail());
            customer.setPhone(customerDTO.getPhone());
            customer.setImageUrl((customerDTO.getImageUrl() == null || customerDTO.getImageUrl().isEmpty()) ? "https://customer-management-images.s3.eu-north-1.amazonaws.com/profile_icon.jpg" : customerDTO.getImageUrl());
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }




}
