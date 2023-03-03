package fr.insy2s.commerce.dtos;

import fr.insy2s.commerce.models.Command;
import fr.insy2s.commerce.models.Payment;
import lombok.Data;

import java.time.LocalDate;
import java.util.Currency;

@Data
public class LineOfPaymentDto {

    private Currency montant;

    private LocalDate paymentDate;

    private Payment payment;

    private Command command;
}
