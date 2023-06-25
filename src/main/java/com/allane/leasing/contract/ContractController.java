package com.allane.leasing.contract;

import com.allane.leasing.customer.Customer;
import com.allane.leasing.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/customers/{customerId}/contracts")
@AllArgsConstructor
public class ContractController {
    private ContractService contractService;
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Contract> createContract(@PathVariable("customerId") Long customerId, @RequestBody Contract contract) {

        Customer customer = customerService.findCustomerById(customerId);
        contract.setCustomer(customer);
        Contract savedContract = contractService.create(contract);
        return new ResponseEntity<>(savedContract, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable("customerId") Long customerId, @PathVariable("id") Long id ) {

        //validate if customer exist
        Customer customer = customerService.findCustomerById(customerId);

        Contract contract = contractService.getContractById(id);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }
}
