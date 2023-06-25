package com.allane.leasing.customer;

import com.allane.leasing.contract.Contract;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name="customers",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"firstName", "lastName"})
)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contract> contracts = new ArrayList<>();

    public void addContract(Contract contract) {
        contracts.add(contract);
        contract.setCustomer(this);
    }

    public void removeContract(Contract contract) {
        contracts.remove(contract);
        contract.setCustomer(null);
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Customer otherCustomer = (Customer) other;

        return id != null && id.equals(otherCustomer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
