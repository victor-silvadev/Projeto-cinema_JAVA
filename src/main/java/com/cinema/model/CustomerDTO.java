package com.cinema.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CustomerDTO {
private String customer;
private String movie;
private double amountSpent;
private SalaEnum salaEnum;
}
