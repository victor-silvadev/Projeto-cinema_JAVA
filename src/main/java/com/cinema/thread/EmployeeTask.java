package com.cinema.thread;


import com.cinema.file.AdminPath;
import com.cinema.file.CustomerPath;
import com.cinema.model.Customer;
import com.cinema.model.CustomerDTO;
import com.cinema.model.Food;
import com.cinema.model.FoodEnum;
import com.cinema.service.AdminServices;
import com.cinema.service.CustomerServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
                case 1 -> {
                    try {
                        executeCustomerTask();

                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }
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

    private  void executeCustomerTask() throws InterruptedException, IOException {
        Customer customerr;
        int movie = 0;
        List<Integer> listProduct = new ArrayList(List.of());

        while (true) {
            System.out.println("\nType your name:");
            String customerName = SCANNER.nextLine();

            System.out.println("\nEnter  your age:");
            int customerInt = Integer.parseInt(SCANNER.nextLine());

            System.out.println("\nEnter the cash you have on hands:");
            double customerPrice = Double.parseDouble(SCANNER.nextLine());

            Customer customer = CustomerServices.createCustomer(customerName, customerInt, customerPrice);
            customerr = customer;
            if (customer == null) {
                System.out.println("Fill in all the information!!!");
                Thread.sleep(2000);
                return;
            } else {
                break;
            }
        }

        boolean inCustomerMenu = true;
        while (inCustomerMenu) {
            System.out.println("\nType what you want to buy first:\n");
            System.out.println("(1) - MOVIE");
            System.out.println("(2) - FOODS");
            System.out.println("(3) - MAKE THE PAYMENT");
            System.out.println("(0) - BACK");
            int numberForMenu = Integer.parseInt(SCANNER.nextLine());


            CustomerServices.checkThePriceOrNameforScreenPrinting(numberForMenu);
            if (numberForMenu == 1) {
                movie = Integer.parseInt(SCANNER.nextLine());

            } else if (numberForMenu == 2) {
                int selectProduct = Integer.parseInt(SCANNER.nextLine());
                listProduct.add(selectProduct);


            } else if (numberForMenu == 3) {
                System.out.println("Directing the client to the room");
                CustomerDTO customerDTO = CustomerServices.validationIfCash(customerr, movie, listProduct);
                CustomerPath.toTakeGoToFile(customerDTO);
                Thread.sleep(2000);
                System.out.printf(".");
                Thread.sleep(2000);
                System.out.printf(".");
                Thread.sleep(2000);
                System.out.printf(".\n");
                Thread.sleep(2000);
                System.out.println("Client directed to the selected room.\n\n");

            } else {
                inCustomerMenu = false;
            }

        }
    }

    private void executeAdminTask() throws IOException, InterruptedException {
        while (true) {
            System.out.println("Type your password:");
            boolean validPassword = AdminServices.validationAdmin(SCANNER.nextLine());
            System.out.println("Checking the password");
            Thread.sleep(2000);
            System.out.printf(".");
            Thread.sleep(2000);
            System.out.printf(".");
            Thread.sleep(2000);
            System.out.printf(".\n");
            if (!validPassword){
                System.out.println("Password is incorrect!!!, Type one number:");
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
                    System.out.println("Creating the movie");
                    Thread.sleep(2000);
                    System.out.printf(".");
                    Thread.sleep(2000);
                    System.out.printf(".\n");
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
                            System.out.println("\nCreating SALGADINHO.");
                            Thread.sleep(2000);
                            System.out.printf(".");
                            Thread.sleep(2000);
                            System.out.printf(".\n");
                            System.out.println("SALGADINHO created!");
                        }
                        case 2 -> {
                            System.out.println("\nBEBIDAS selected, enter the price of the BEBIDAS:");
                            System.out.println("Exemple: 00.00");
                            double priceProductDouble = Double.parseDouble(SCANNER.nextLine());
                            Food food = new Food(FoodEnum.BEBIDAS,priceProductDouble);
                            AdminPath.createProductsPath(food);
                            System.out.println("\nCreating BEBIDAS.");
                            Thread.sleep(2000);
                            System.out.printf(".");
                            Thread.sleep(2000);
                            System.out.printf(".\n");
                            System.out.println("BEBIDAS created!");
                        }
                        case 3 -> {
                            System.out.println("\nPIPOCA selected, enter the price of the PIPOCA:");
                            System.out.println("Exemple: 00.00");
                            double priceProductDouble = Double.parseDouble(SCANNER.nextLine());
                            Food food = new Food(FoodEnum.PIPOCA,priceProductDouble);
                            AdminPath.createProductsPath(food);
                            System.out.println("\nCreating PIPOCA.");
                            Thread.sleep(2000);
                            System.out.printf(".");
                            Thread.sleep(2000);
                            System.out.printf(".\n");
                            System.out.println("PIPOCA created!");
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
