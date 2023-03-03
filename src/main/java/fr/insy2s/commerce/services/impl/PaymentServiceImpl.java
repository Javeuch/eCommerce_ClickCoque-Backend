package fr.insy2s.commerce.services.impl;

import fr.insy2s.commerce.dtos.PaymentDto;
import fr.insy2s.commerce.models.Payment;
import fr.insy2s.commerce.repositories.IPaymentRepository;
import fr.insy2s.commerce.services.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService {
    private final IPaymentRepository paymentRepository;

    private final ModelMapper modelMapper;

    @Override
    public PaymentDto findByIt(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        return modelMapper.map(payment,PaymentDto.class);
    }

    @Override
    public List<PaymentDto> getAllPayments(){
        return paymentRepository.findAll()
                .stream()
                .map(payment -> modelMapper.map(payment,PaymentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Payment addPayment(Payment payment) {return paymentRepository.save(payment);}

    @Override
    public void deletePayment(Long id) {paymentRepository.deleteById(id);}
}

