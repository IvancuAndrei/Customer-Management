package com.customerapp.customer_management_backend.service;

import com.customerapp.customer_management_backend.entity.dto.CustomerDTO;
import com.customerapp.customer_management_backend.entity.Customer;

public interface CustomerService {

    Customer createCustomer(CustomerDTO customerDTO);
    Customer getCustomerById(Long id);
    void deleteCustomer(Long id);
    Customer updateCustomer(Long id, CustomerDTO customerDTO);
}
