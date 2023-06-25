package com.allane.leasing.vehicle;

import com.allane.leasing.contract.Contract;
import com.allane.leasing.contract.ContractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleService {
    private VehicleRepository VehicleRepository;
    private ContractRepository contractRepository;

    public Vehicle create(Vehicle vehicle) {
        return VehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        List<Contract> contracts = contractRepository.findContractByVehicleId(id);

        if(!contracts.isEmpty()) {
            throw new RuntimeException("vehicle can not be deleted, leasing contract exist");
        }
        VehicleRepository.deleteById(id);
    }

    public Vehicle findVehicleById(Long id) {
        Optional<Vehicle> optionalVehicle = VehicleRepository.findById(id);
        if(optionalVehicle.isEmpty()) {
            throw  new RuntimeException("Vehicle does not exist");
        }
        return optionalVehicle.get();
    }
}
