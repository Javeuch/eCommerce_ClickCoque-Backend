package fr.insy2s.commerce.controllers;


import fr.insy2s.commerce.dtos.LineOfPaymentDto;
import fr.insy2s.commerce.models.LineOfPayment;
import fr.insy2s.commerce.services.ILineOfPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/LineOfPayment")
public class LineOfPaymentController {
    private final ILineOfPaymentService lineOfPaymentService;

    @GetMapping("/all")
    public List<LineOfPaymentDto> getAllLineOfPayments() {
        return lineOfPaymentService.getAllLineOfPayments();
    }

    @GetMapping("/detail/{id}")
    public LineOfPaymentDto payment(@PathVariable Long id) {
        return lineOfPaymentService.findById(id);
    }

    @PostMapping("/add")
    public LineOfPayment addLineOfPayment(@Validated @RequestBody LineOfPayment lineOfPayment) {
        return lineOfPaymentService.addLineOfPayment(lineOfPayment);
    }

    @PostMapping("/delete/{id}")
    public void deleteLineOfPayment(@PathVariable Long id) {
        lineOfPaymentService.deleteLineOfPayment(id);
    }
}
