package com.cinema.file;

import com.cinema.model.Food;
import com.cinema.model.FoodEnum;
import com.cinema.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class AdminPathTest {
private static void movieAndProductAndPath(){
    Movie movie = new Movie("Homem aranha",112.00);
    Food food = new Food(FoodEnum.BEBIDAS, 12.50);
    Path bebidas = Paths.get("cinema_data/Produtos/BEBIDAS_Preco.txt");
    Path f1 = Paths.get("cinema_data/salas/sala_01/Filme_Sala01.txt");
}
    @Test
    void is_Create_Products() {
    }

    @Test
    void is_Create_Movies() {
    }
}