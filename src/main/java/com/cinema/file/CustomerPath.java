package com.cinema.file;

import com.cinema.exception.InexistingPathException;
import com.cinema.model.CustomerDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CustomerPath {

    public static void toTakeGoToFile(CustomerDTO customerDTO) throws IOException {
        Path sala01 = Paths.get("C:\\Users\\conta\\Documents\\estudos\\JAVA\\Projeto-Cinema_JAVA\\cinema_data\\salas\\sala_01\\Sala_01.txt");
        Path sala02 = Paths.get("C:\\Users\\conta\\Documents\\estudos\\JAVA\\Projeto-Cinema_JAVA\\cinema_data\\salas\\sala_02\\Sala_02.txt");
        Path sala03 = Paths.get("C:\\Users\\conta\\Documents\\estudos\\JAVA\\Projeto-Cinema_JAVA\\cinema_data\\salas\\sala_03\\Sala_03.txt");

        switch (customerDTO.getSalaEnum()){
            case SALA01 -> Files.write(sala01, List.of(customerDTO.toFileString()), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            case SALA02 -> Files.write(sala02, List.of(customerDTO.toFileString()), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            case SALA03 -> Files.write(sala03, List.of(customerDTO.toFileString()), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            default -> throw new InexistingPathException("This path don't existing");
        }
    }
}