package com.cinema.service;

import com.cinema.exception.AdministratorPasswordIsIncorrectException;
import com.cinema.model.Admin;


public class AdminServices {

    public static boolean  validationAdmin(String password){

        if (password.isBlank()){
            System.out.println("The password is null");
            return false;

        } else if (!password.equals(Admin.DEFAULT_ADMIN.getPASSWORD())){
            System.out.println("The password is incorrect");
            return false;

        } else {
            System.out.println("Access granted!");
            return true;
        }

    }
}
