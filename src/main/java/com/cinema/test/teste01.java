package com.cinema.test;

import com.cinema.thread.EmployeeTask;

public class teste01 {
    public static void main(String[] args) {

    EmployeeTask employeeTask = new EmployeeTask();
    Thread thread = new Thread(employeeTask);
    thread.start();
    }
}
