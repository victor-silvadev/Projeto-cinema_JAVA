package com.cinema.thread;



import com.cinema.model.Admin;
import com.cinema.service.AdminServices;

import java.util.Scanner;

public class EmployeeTask implements Runnable{
    private static final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void run() {
        System.out.println("Type the option:\n");
        System.out.println("(1) - CUSTOMER");
        System.out.println("(2) - ADMIN");
        System.out.println("(0) - EXIT");
        int i = SCANNER.nextInt();
        switch (i){
            case 1 -> executeCustomerTask();
            case 2 -> executeAdminTask();
            case 0 -> SCANNER.close();
            default -> throw new IllegalArgumentException("Ilegal argument!");
        }
    }

    private  void executeCustomerTask() {

    }

    private void executeAdminTask() {
        Admin admin = Admin.builder().name("Admin").password("22087612Vt").build();
        while (true) {
            System.out.println("Type your password");
            String password = SCANNER.nextLine();
            boolean validPassword = AdminServices.validationAdmin(admin, password);
            if (!validPassword){
                System.out.println("Password incorrect, type one number:");
                System.out.println("(1) - TRY AGAIN");
                System.out.println("(2) - RETURN");
                int decidion = SCANNER.nextInt();

                if (decidion == 2) return;
            }


        }
    }
}
