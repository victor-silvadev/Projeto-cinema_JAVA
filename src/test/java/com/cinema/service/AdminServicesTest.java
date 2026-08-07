package com.cinema.service;

import com.cinema.exception.AdministratorPasswordIsIncorrectException;
import com.cinema.model.Admin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;




class AdminServicesTest {

    @Test
    void validation_about_password_from_Admin_is_Correct() {
        String password = "22aO76";
        Assertions.assertDoesNotThrow(() -> AdminServices.validationAdmin(password));
    }

    @Test
    void validation_Not_Authorized_about_password_from_input_is_Null() {
        String password = " ";
        Assertions.assertThrows(AdministratorPasswordIsIncorrectException.class, () -> AdminServices.validationAdmin(password));
    }
}