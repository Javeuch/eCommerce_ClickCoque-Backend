package fr.insy2s.commerce.dtos;

import fr.insy2s.commerce.models.Account;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentDto {

    private Integer cardNumber;

    private Integer ccv;

    private LocalDate expirationDate;

    private Account user;
}
