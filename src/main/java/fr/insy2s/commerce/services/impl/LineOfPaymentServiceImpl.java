package fr.insy2s.commerce.services.impl;

import fr.insy2s.commerce.dtos.LineOfPaymentDto;
import fr.insy2s.commerce.models.LineOfPayment;
import fr.insy2s.commerce.repositories.ILineOfPaymentRepository;
import fr.insy2s.commerce.services.ILineOfPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LineOfPaymentServiceImpl implements ILineOfPaymentService {

    private final ILineOfPaymentRepository lineOfPaymentRepository;
    private final ModelMapper modelMapper;

    @Override
    public LineOfPaymentDto findById(Long id) {
        LineOfPayment lineOfPayment = lineOfPaymentRepository.findById(id).orElse(null);
        return modelMapper.map(lineOfPayment, LineOfPaymentDto.class);
    }

    @Override
    public List<LineOfPaymentDto> getAllLineOfPayments() {
        return lineOfPaymentRepository.findAll()
                .stream()
                .map(lineOfPayment -> modelMapper.map(lineOfPayment, LineOfPaymentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public LineOfPayment addLineOfPayment(LineOfPayment lineOfPayment) {
        return lineOfPaymentRepository.save(lineOfPayment);
    }

    @Override
    public void deleteLineOfPayment(Long id) {
        lineOfPaymentRepository.deleteById(id);
    }
}
