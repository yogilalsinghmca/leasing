package com.allane.leasing.vehicle;


import com.allane.leasing.contract.Contract;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Brand;
    private String model;
    private Integer modelYear;
    private String vehicleIdentificationNumber;
    private BigDecimal price;


    @OneToOne(mappedBy = "vehicle", targetEntity = Contract.class, cascade = {CascadeType.MERGE, CascadeType.REMOVE},orphanRemoval = true )
    private Contract contract;

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Vehicle otherVehicle = (Vehicle) other;

        return id != null && id.equals(otherVehicle.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
