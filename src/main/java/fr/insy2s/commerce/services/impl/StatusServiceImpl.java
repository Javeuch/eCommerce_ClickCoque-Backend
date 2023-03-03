package fr.insy2s.commerce.services.impl;

import fr.insy2s.commerce.dtos.StatusDto;
import fr.insy2s.commerce.models.Status;
import fr.insy2s.commerce.repositories.IStatusRepository;
import fr.insy2s.commerce.services.IStatusService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements IStatusService {

    private final IStatusRepository statusRepository;
    private final ModelMapper modelMapper;

    @Override
    public StatusDto findById(Long id){
        Status status = statusRepository.findById(id).orElse(null);
        return modelMapper.map(status, StatusDto.class);
    }
    @Override
    public List<StatusDto>getAllStatutes(){
        return statusRepository.findAll()
                .stream()
                .map(status -> modelMapper.map(status,StatusDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public Status addStatus(Status status){return statusRepository.save(status);}

    @Override
    public void deleteStatus(Long id) {statusRepository.deleteById(id);}




}
