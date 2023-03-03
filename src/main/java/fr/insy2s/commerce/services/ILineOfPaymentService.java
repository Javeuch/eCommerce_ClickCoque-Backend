package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.LineOfPaymentDto;
import fr.insy2s.commerce.models.LineOfPayment;

import java.util.List;

public interface ILineOfPaymentService {

    LineOfPaymentDto findById(Long id);

    List<LineOfPaymentDto> getAllLineOfPayments();

    LineOfPayment addLineOfPayment(LineOfPayment lineOfPayment);

    void deleteLineOfPayment(Long id);
}
