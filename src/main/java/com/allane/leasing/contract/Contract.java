package com.allane.leasing.contract;

import com.allane.leasing.customer.Customer;
import com.allane.leasing.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractNumber;

    private BigDecimal monthlyRate;

    @ManyToOne
    @JoinColumn(name ="customer_id")
    private Customer customer;

    @OneToOne()
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Contract otherContract = (Contract) other;

        return contractNumber != null && contractNumber.equals(otherContract.contractNumber);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
