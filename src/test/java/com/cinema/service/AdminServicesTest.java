package com.cinema.service;

import com.cinema.exception.AdministratorPasswordIsIncorrectException;
import com.cinema.model.Admin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;




class AdminServicesTest {

    @Test
    void validation_about_password_from_Admin_is_Correct() {
        Admin admin = Admin.builder().password("22aO76").build();
        String password = "22aO76";
        Assertions.assertDoesNotThrow(() -> AdminServices.validationAdmin(admin, password));
    }

    @Test
    void validation_Not_Authorized_about_password_from_input_is_Null() {
        Admin admin = Admin.builder().password("22aO76").build();
        String password = " ";
        Assertions.assertThrows(AdministratorPasswordIsIncorrectException.class, () -> AdminServices.validationAdmin(admin, password));
    }
}