package fr.insy2s.commerce.controllers;

import fr.insy2s.commerce.dtos.StatusDto;
import fr.insy2s.commerce.models.Status;
import fr.insy2s.commerce.services.IStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/Status")
public class StatusController {
    private final IStatusService statusService;

    @GetMapping("/all")
    public List<StatusDto> getAllStatues(){return statusService.getAllStatutes();}

    @GetMapping("/detail/{id}")
    public StatusDto status(@PathVariable Long id) {return statusService.findById(id);}

    @PostMapping("/add")
    public Status addStatus(@PathVariable @RequestBody Status status){return statusService.addStatus(status);}

    @DeleteMapping("/delete/{id}")
    public void deleteStatus(@PathVariable Long id) {statusService.deleteStatus(id);}

}
