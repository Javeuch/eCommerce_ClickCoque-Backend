package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.StatusDto;
import fr.insy2s.commerce.models.Status;

import java.util.List;

public interface IStatusService {

    StatusDto findById(Long id);

    List<StatusDto> getAllStatutes();

    Status addStatus(Status status);

    void deleteStatus(Long id);
}
