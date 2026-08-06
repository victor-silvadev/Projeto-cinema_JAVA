package com.cinema.file;

import com.cinema.model.Food;
import com.cinema.model.FoodEnum;
import com.cinema.model.Movie;


import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class AdminPath {
// cria os produtos a serem vendidos
    public static void createProductsPath(Food food) throws IOException {
        String priceString = String.valueOf(food.price());
        switch (food.nameProduct()) {
            case FoodEnum.PIPOCA -> {
                Path pipoca = Paths.get("cinema_data/Produtos/PIPOCA_Preco.txt");
                Files.write(pipoca, List.of(priceString), StandardOpenOption.CREATE);
            }

            case FoodEnum.BEBIDAS -> {
                Path bebidas = Paths.get("cinema_data/Produtos/BEBIDAS_Preco.txt");
                Files.write(bebidas, List.of(priceString), StandardOpenOption.CREATE);
            }

            case FoodEnum.SALGADINHO -> {
                Path salgadinho = Paths.get("cinema_data/Produtos/SALGADINHO_Preco.txt");
                Files.write(salgadinho, List.of(priceString), StandardOpenOption.CREATE);
            }

            default -> throw new IllegalStateException("Illegal value: " + food);
        }
    }

// Faz a criaçao dos filmes
    public static void createMoviesPath(Movie movie, int movieTheater) throws IOException {
        Path f1 = Paths.get("cinema_data/salas/sala_01/Filme_Sala01.txt");
        Path f2 = Paths.get("cinema_data/salas/sala_02/Filme_Sala02.txt");
        Path f3 = Paths.get("cinema_data/salas/sala_03/Filme_Sala03.txt");
        String movieString = String.valueOf(movie);

        switch (movieTheater){
            case 1 -> Files.write(f1, List.of(movieString), StandardOpenOption.CREATE);
            case 2 -> Files.write(f2, List.of(movieString), StandardOpenOption.CREATE);
            case 3 -> Files.write(f3, List.of(movieString), StandardOpenOption.CREATE);
            default -> throw new IllegalStateException("Illegal value: " + movieTheater);
        }

    }
}
