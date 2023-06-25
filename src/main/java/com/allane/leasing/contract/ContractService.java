package com.allane.leasing.contract;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContractService {
    private ContractRepository contractRepository;

    public List<Contract> findContractByCustomerId(Long customerId) {
        return contractRepository.findContractByCustomerId(customerId);
    }

    public Contract create(Contract contract) {
        return contractRepository.save(contract);
    }

    public Contract getContractById(Long id) {
        Optional<Contract> optionalContract = contractRepository.findById(id);
        return optionalContract.orElseThrow();
    }
}
