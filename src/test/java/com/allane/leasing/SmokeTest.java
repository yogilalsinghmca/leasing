package com.allane.leasing;


import com.allane.leasing.contract.ContractController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class SmokeTest {
    @Autowired
    private ContractController contractController;

    @Test
    public void contextLoads() {
        assertThat(contractController).isNotNull();
    }
}
