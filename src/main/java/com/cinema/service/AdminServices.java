package com.cinema.service;

import com.cinema.exception.AdministratorPasswordIsIncorrectException;
import com.cinema.model.Admin;


public class AdminServices {

    public static boolean  validationAdmin(String password){

        if (password.isBlank() || password == null){
            System.out.println("The password is null or isBlank");
            return false;

        } else if (!password.trim().equals(Admin.DEFAULT_ADMIN.getPASSWORD())){
            System.out.println(Admin.DEFAULT_ADMIN.getPASSWORD());
            System.out.println(password);
            System.out.println("The password is incorrect");
            return false;

        } else {
            System.out.println("Access granted!");
            return true;
        }

    }
}
