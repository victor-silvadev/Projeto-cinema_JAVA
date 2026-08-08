package com.cinema.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Data
@ToString
@Builder
public class CustomerDTO {
private String customer;
private String movie;
private double amountSpent;
private SalaEnum salaEnum;

public String toFileString(){
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
    DecimalFormat df = new DecimalFormat("0.00", symbols);

    return "( NAME: " + this.customer + " ;  MOVIE: " + this.movie + "; AMOUNTSPENT: R$" + df.format(this.amountSpent) + "; SALA: " + this.salaEnum + " )";
}
}
