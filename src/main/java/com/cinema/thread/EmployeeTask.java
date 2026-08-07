package com.cinema.thread;


import com.cinema.file.AdminPath;
import com.cinema.model.Food;
import com.cinema.model.FoodEnum;
import com.cinema.service.AdminServices;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeTask implements Runnable{
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            System.out.println("Type the option:\n");
            System.out.println("(1) - CUSTOMER");
            System.out.println("(2) - ADMIN");
            System.out.println("(0) - EXIT");
            int i = Integer.parseInt(SCANNER.nextLine());
            switch (i) {
                case 1 -> executeCustomerTask();
                case 2 -> {
                    try {
                        executeAdminTask();

                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 0 -> {
                    System.out.println("Good bye");
                    return;
                }
                default -> System.out.println("Select only the displayed numbers!!!!");
            }
        }
    }

    private  void executeCustomerTask() {

    }

    private void executeAdminTask() throws IOException, InterruptedException {
        while (true) {
            System.out.println("Type your password:");
            String password = SCANNER.nextLine();
            boolean validPassword = AdminServices.validationAdmin(password);
            if (!validPassword){
                System.out.println("Type one number:");
                System.out.println("(1) - TRY AGAIN");
                System.out.println("(2) - BACK");
                int decidion = Integer.parseInt(SCANNER.nextLine());

                if (decidion == 2) return;

            } else {
                break;
            }

        }

        while (true) {
            System.out.println("\nSelect one number:\n");
            System.out.println("(1) - MOVIE REGISTRATION");
            System.out.println("(2) - PRODUCT REGISTRATION");
            System.out.println("(0) - BACK");
            int intNumber = Integer.parseInt(SCANNER.nextLine());

            switch (intNumber) {
                case  1 -> {
                    System.out.println("\nEnter the movie tittle:");
                    String movieName = SCANNER.nextLine();
                    System.out.println("\nEnter the ticket price:");
                    double ticketPriceDouble = Double.parseDouble(SCANNER.nextLine());

                    System.out.println("\nEnter the theater number where the movie will be shown:\n");
                    System.out.println("(1) - ROMM 01");
                    System.out.println("(2) - ROMM 02");
                    System.out.println("(3) - ROMM 03");
                    int movieTheaterInt = Integer.parseInt(SCANNER.nextLine());

                    AdminPath.createMoviesPath(movieName,ticketPriceDouble,movieTheaterInt);
                    System.out.println("Creating the movie...");
                    Thread.sleep(2000);
                    System.out.println("Movie created!");
                }
                case  2 -> {
                    System.out.println("\nType one letter:\n");
                    System.out.println("(1) - SALGADINHO");
                    System.out.println("(2) - BEBIDAS");
                    System.out.println("(3) - PIPOCA");
                    System.out.println("(0) - RETURN");
                    String numberSelected = SCANNER.nextLine();
                    int i = Integer.parseInt(numberSelected);

                    switch (i){
                        case 1 -> {
                            System.out.println("\nSALGADINHO selected, enter the price of the SALGADINHO:");
                            System.out.println("Exemple: 00.00");
                            double priceProductDouble = Double.parseDouble(SCANNER.nextLine());
                            Food food = new Food(FoodEnum.SALGADINHO,priceProductDouble);
                            AdminPath.createProductsPath(food);
                            System.out.println("\nCreating SALGADINHO...");
                            Thread.sleep(2000);
                            System.out.println("\nSALGADINHO created!");
                        }
                        case 2 -> {
                            System.out.println("\nBEBIDAS selected, enter the price of the BEBIDAS:");
                            System.out.println("Exemple: 00.00");
                            double priceProductDouble = Double.parseDouble(SCANNER.nextLine());
                            Food food = new Food(FoodEnum.BEBIDAS,priceProductDouble);
                            AdminPath.createProductsPath(food);
                            System.out.println("\nCreating BEBIDAS...");
                            Thread.sleep(2000);
                            System.out.println("\nBEBIDAS created!");
                        }
                        case 3 -> {
                            System.out.println("\nPIPOCA selected, enter the price of the PIPOCA:");
                            System.out.println("Exemple: 00.00");
                            double priceProductDouble = Double.parseDouble(SCANNER.nextLine());
                            Food food = new Food(FoodEnum.PIPOCA,priceProductDouble);
                            AdminPath.createProductsPath(food);
                            System.out.println("\nCreating PIPOCA...");
                            Thread.sleep(2000);
                            System.out.println("\nPIPOCA created!");
                        }
                        case 0 -> {
                            return;
                        }
                    }

                }
                case  0 -> {
                    return;
                }
                default -> System.out.println("Select only the displayed numbers!!!!");
            }
        }
    }
}
