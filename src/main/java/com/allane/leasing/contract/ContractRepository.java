package com.allane.leasing.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findContractByCustomerId(Long customerId);
    List<Contract> findContractByVehicleId(Long vehicleId);

}
