package com.cinema.file;

import com.cinema.model.CustomerDTO;
import com.cinema.model.SalaEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerPathTest {

    @Test
    void create_customerDTO_In_Path_Select() {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .customer("victor")
                .movie("Atlas")
                .amountSpent(287)
                .salaEnum(SalaEnum.SALA01)
                .build();
        Assertions.assertDoesNotThrow(() -> CustomerPath.toTakeGoToFile(customerDTO));
    }
}