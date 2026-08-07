package com.cinema.model;


import lombok.Data;


@Data
public class Admin {
    String NAME;
    String PASSWORD;

    public static final Admin DEFAULT_ADMIN = new Admin("Admin","2208");

    public Admin(String admin, String number) {
    }

}

