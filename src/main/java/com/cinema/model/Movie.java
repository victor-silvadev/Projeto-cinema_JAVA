package com.cinema.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public record Movie(String tittle, double price) {

    public String toFileString() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        return "| MOVIE: " + this.tittle + " ; | PRICE: " + df.format(this.price);
    }
}
