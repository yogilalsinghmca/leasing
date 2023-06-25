package com.allane.leasing.customer;

import com.allane.leasing.contract.Contract;
import com.allane.leasing.contract.ContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private ContractRepository contractRepository;

    public Customer create(Customer customer) {
        if (customer.getFirstName() == null || customer.getFirstName().isEmpty()) {
            throw new RuntimeException("first name can not be empty or null");
        }

        if (customer.getLastName() == null || customer.getLastName().isEmpty()) {
            throw new RuntimeException("last name can not be empty or null");
        }
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        List<Contract> contracts = contractRepository.findContractByCustomerId(id);

        if(!contracts.isEmpty()) {
            throw new RuntimeException("customer can not be deleted, leasing contract exist");
        }
        customerRepository.deleteById(id);
    }
    public Customer updateCustomer(Customer customer) {
        Customer customerFromDb = customerRepository.findById(customer.getId()).orElseThrow();
        customerFromDb.setFirstName(customer.getFirstName());
        customerFromDb.setLastName(customer.getLastName());
        customerFromDb.setBirthDate(customer.getBirthDate());
        return customerRepository.save(customerFromDb);
    }

    public Customer findCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()) {
           throw  new RuntimeException("Customer does not exist");
        }
        return optionalCustomer.get();
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Contract> getContractByCustomerId(Long customerId) {
        return contractRepository.findContractByCustomerId(customerId);
    }
}
