package com.allane.leasing.customer;


import com.allane.leasing.contract.ContractService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private ContractService contractService;

    private Customer givenCustomer;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        givenCustomer = new Customer();
        givenCustomer.setFirstName("Yogi");
        givenCustomer.setLastName("Singh");
        givenCustomer.setBirthDate(LocalDate.now().minusYears(38));
    }

    @Test
    public void shouldCreateCustomerAndReturn() throws Exception {

        String jsonCustomer = objectMapper.writeValueAsString(givenCustomer);
        when(customerService.create(any(Customer.class))).thenReturn(givenCustomer);

        mockMvc.perform(post("/v1/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCustomer))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(content().string(jsonCustomer));
    }
}
