package com.cinema.service;

import com.cinema.exception.AdministratorPasswordIsIncorrectException;
import com.cinema.model.Admin;


public class AdminServices {

    public static boolean  validationAdmin(Admin admin,String password){
        if (password.isBlank()){
            throw new AdministratorPasswordIsIncorrectException("The password is null");

        } else if (!password.equals(admin.getPassword())){
            throw new AdministratorPasswordIsIncorrectException("The password is incorret");

        } else {
            System.out.println("Acesso liberado!");
            return true;
        }

    }
}
