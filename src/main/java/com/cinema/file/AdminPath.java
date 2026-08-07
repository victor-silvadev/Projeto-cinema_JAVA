package com.cinema.file;

import com.cinema.model.Food;
import com.cinema.model.FoodEnum;
import com.cinema.model.Movie;


import java.io.IOException;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class AdminPath {
// cria os produtos a serem vendidos
    public static void createProductsPath(Food food) throws IOException {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00",symbols);
        String priceFormated = df.format(food.price());
        switch (food.nameProduct()) {
            case FoodEnum.PIPOCA -> {
                Path pipoca = Paths.get("cinema_data/Produtos/PIPOCA_Preco.txt");
                Files.write(pipoca, List.of(priceFormated), StandardOpenOption.CREATE);
            }

            case FoodEnum.BEBIDAS -> {
                Path bebidas = Paths.get("cinema_data/Produtos/BEBIDAS_Preco.txt");
                Files.write(bebidas, List.of(priceFormated), StandardOpenOption.CREATE);
            }

            case FoodEnum.SALGADINHO -> {
                Path salgadinho = Paths.get("cinema_data/Produtos/SALGADINHO_Preco.txt");
                Files.write(salgadinho, List.of(priceFormated), StandardOpenOption.CREATE);
            }

            default -> throw new IllegalStateException("Illegal value: " + food);
        }
    }

// Faz a criaçao dos filmes
    public static void createMoviesPath(String nameMovie,double ticketPrice, int movieTheater) throws IOException {
        Path f1 = Paths.get("cinema_data/salas/sala_01/Filme_Sala01.txt");
        Path f2 = Paths.get("cinema_data/salas/sala_02/Filme_Sala02.txt");
        Path f3 = Paths.get("cinema_data/salas/sala_03/Filme_Sala03.txt");
        Movie movie = new Movie(nameMovie,ticketPrice);

        switch (movieTheater){
            case 1 -> Files.write(f1, List.of(movie.toFileString()), StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            case 2 -> Files.write(f2, List.of(movie.toFileString()), StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            case 3 -> Files.write(f3, List.of(movie.toFileString()), StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            default -> throw new IllegalStateException("Illegal value: " + movieTheater);
        }

    }
}
