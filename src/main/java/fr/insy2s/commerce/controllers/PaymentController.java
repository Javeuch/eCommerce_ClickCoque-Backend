package fr.insy2s.commerce.controllers;

import fr.insy2s.commerce.dtos.PaymentDto;
import fr.insy2s.commerce.models.Payment;
import fr.insy2s.commerce.services.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/payment")
public class PaymentController {

    private final IPaymentService paymentService;

    @GetMapping("/all")
    public List<PaymentDto> getAllPayments(){return paymentService.getAllPayments();}

    @GetMapping("/detail/{id}")
    public PaymentDto pay(@PathVariable Long id) {return paymentService.findByIt(id);}

    @PostMapping("/add")
    public Payment addPayment(@Validated @RequestBody Payment payment){return paymentService.addPayment(payment);}

    @DeleteMapping ("/delete/{id}")
    public void deleteAccount(@PathVariable Long id) {paymentService.deletePayment(id);}
}
