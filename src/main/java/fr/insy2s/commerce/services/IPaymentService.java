package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.PaymentDto;
import fr.insy2s.commerce.models.Payment;

import java.util.List;

public interface IPaymentService  {
    PaymentDto findByIt(Long id);

    List<PaymentDto> getAllPayments();

    Payment addPayment(Payment payment);

    void deletePayment(Long id);
}
