package com.cinema.service;

import com.cinema.exception.CustomerInvalidException;
import com.cinema.model.Customer;
import com.cinema.model.CustomerDTO;
import com.cinema.model.SalaEnum;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class CustomerServices {

// Cria o cliente automaticamente
    public static Customer createCustomer(String name, int age, double cash) {
        if (name.isBlank() || age == 0 || cash == 0.0) throw new CustomerInvalidException("Fill in all fidelds!");

        return Customer.builder()
                .name(name)
                .age(age)
                .cash(cash)
                .build();
    }


// verifica se se o cliente tem dinheiro suficiente para efetua a compra solicitada de filme/produtos e retorna um clienteDTO
// para ser salvo na pasta sala com as informaçoes necessarias
    public static CustomerDTO validationIfCash(Customer customer, Integer movie, List<Integer> products) throws IOException {
        SalaEnum salaEnum = null;
        double valueMovie = 0;
        String nameMovie = "";


        double valueProducts = 0;

        double valueRelatory = 0;

        Path bebidas = Paths.get("C:\\Users\\conta\\Documents\\estudos\\JAVA\\Projeto-Cinema_JAVA\\cinema_data\\Produtos\\BEBIDAS_Preco.txt");
        Path pipoca = Paths.get("C:\\Users\\conta\\Documents\\estudos\\JAVA\\Projeto-Cinema_JAVA\\cinema_data\\Produtos\\PIPOCA_Preco.txt");
        Path salgadinho = Paths.get("C:\\Users\\conta\\Documents\\estudos\\JAVA\\Projeto-Cinema_JAVA\\cinema_data\\Produtos\\SALGADINHOS_Preco.txt");

        Path sala01 = Paths.get("C:\\Users\\conta\\Documents\\estudos\\JAVA\\Projeto-Cinema_JAVA\\cinema_data\\salas\\sala_01\\Filme_Sala01.txt");
        Path sala02 = Paths.get("C:\\Users\\conta\\Documents\\estudos\\JAVA\\Projeto-Cinema_JAVA\\cinema_data\\salas\\sala_02\\Filme_Sala02.txt");
        Path sala03 = Paths.get("C:\\Users\\conta\\Documents\\estudos\\JAVA\\Projeto-Cinema_JAVA\\cinema_data\\salas\\sala_03\\Filme_Sala03.txt");

        switch (movie) {
            case 1 -> {
                List<String> lines = Files.readAllLines(sala01);
                for (String line : lines) {
                    String[] partAboutLines = line.split(",");
                    if (partAboutLines.length >= 2) {
                        String tittle = partAboutLines[0].trim();

                        String priceString = partAboutLines[1].trim();
                        priceString = priceString.replace("]","");
                        double priceDouble = Double.parseDouble(priceString.replace("price=",""));
                        valueMovie += priceDouble;
                        nameMovie = tittle;
                        salaEnum = SalaEnum.SALA01;

                    }

                }
            }
            case 2 -> {
                List<String> lines = Files.readAllLines(sala02);
                for (String line : lines) {
                    String[] partAboutLines = line.split(",");
                    if (partAboutLines.length >= 2) {
                        String tittle = partAboutLines[0].trim();

                        String priceString = partAboutLines[1].trim().replace(",", ".");
                        double priceDouble = Double.parseDouble(priceString);
                        valueMovie += priceDouble;
                        nameMovie = tittle;
                        salaEnum = SalaEnum.SALA02;
                    }

                }
            }
            case 3 -> {
                List<String> lines = Files.readAllLines(sala03);
                for (String line : lines) {
                    String[] partAboutLines = line.split(",");
                    if (partAboutLines.length >= 2) {
                        String tittle = partAboutLines[0].trim();

                        String priceString = partAboutLines[1].trim().replace(",", ".");
                        double priceDouble = Double.parseDouble(priceString);
                        valueMovie += priceDouble;
                        nameMovie = tittle;
                        salaEnum = SalaEnum.SALA03;
                    }

                }
            }
            default -> {
                nameMovie = null;
                valueProducts = 0;
                salaEnum = null;
            }
        }




        for (Integer product : products) {
            switch (product) {
                case 1 -> {
                    List<String> lines = Files.readAllLines(bebidas);
                    String priceString = lines.getFirst();
                    double priceDouble = Double.parseDouble(priceString);
                    valueProducts += priceDouble;
                }
                case 2 -> {
                    List<String> lines = Files.readAllLines(pipoca);
                    String priceString = lines.getFirst();
                    double priceDouble = Double.parseDouble(priceString);
                    valueProducts += priceDouble;
                }
                case 3 -> {
                    List<String> lines = Files.readAllLines(salgadinho);
                    String priceString = lines.getFirst();
                    double priceDouble = Double.parseDouble(priceString);
                    valueProducts += priceDouble;
                }
                default -> valueProducts = 0;
            }

        }

        valueRelatory = valueProducts + valueMovie;

        if (customer.getCash() < valueRelatory){
            throw new CustomerInvalidException("Your cash don't is enough!");

        } else if (nameMovie.isBlank()) throw new CustomerInvalidException("Select one movie for continue!");

        return CustomerDTO.builder()
                .customer(customer.getName())
                .movie(nameMovie)
                .amountSpent(valueRelatory)
                .salaEnum(salaEnum)
                .build();
    }

}
