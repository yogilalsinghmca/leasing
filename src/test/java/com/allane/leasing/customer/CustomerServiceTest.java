package com.allane.leasing.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer givenCustomer;

    @BeforeEach
    public void setup() {
        givenCustomer = new Customer();
        givenCustomer.setFirstName("Yogi");
        givenCustomer.setLastName("Singh");
        givenCustomer.setBirthDate(LocalDate.now().minusYears(38));
    }

    @Test
    public void shouldCreateCustomer() {
        when(customerRepository.save(givenCustomer)).thenReturn(givenCustomer);

        Customer actualCustomer = customerService.create(givenCustomer);
        verify(customerRepository, times(1)).save(any(Customer.class));

        assertEquals(givenCustomer.getFirstName(), actualCustomer.getFirstName());
        assertEquals(givenCustomer.getLastName(), actualCustomer.getLastName());
        assertEquals(givenCustomer.getBirthDate(), actualCustomer.getBirthDate());
    }

    @Test
    public void createCustomerWithoutFirstNameAndExpectException() {
        assertThrows(RuntimeException.class, () -> {
            givenCustomer.setFirstName(null);
            customerService.create(givenCustomer);
        });
    }

    @Test
    public void createCustomerWithoutLastNameAndExpectException() {
        assertThrows(RuntimeException.class, () -> {
            givenCustomer.setLastName(null);
            customerService.create(givenCustomer);
        });
    }

}
