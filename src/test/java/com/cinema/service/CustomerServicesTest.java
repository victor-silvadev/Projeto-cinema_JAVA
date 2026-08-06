package com.cinema.service;

import com.cinema.exception.CustomerInvalidException;
import com.cinema.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServicesTest {

    @Test
    void create_Is_New_Customer() {
        Assertions.assertDoesNotThrow(() -> CustomerServices.createCustomer("vito",10,100.00));
    }


    @Test
    void create_Dont_Validation_for_Input_is_Null() {
        Assertions.assertThrows(CustomerInvalidException.class, () -> CustomerServices.createCustomer(" ", 0,100.00));
    }

    @Test
    void verification_about_cash_Ofthe_Customer_With_the_Full_Payment_amount() {

        Customer customer = Customer.builder()
                .name("victor")
                .age(18)
                .cash(500)
                .build();
        Assertions.assertDoesNotThrow(() -> CustomerServices.validationIfCash(customer,1, List.of(2)));
    }
}