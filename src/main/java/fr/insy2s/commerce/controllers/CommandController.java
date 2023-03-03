package fr.insy2s.commerce.controllers;

import fr.insy2s.commerce.dtos.CommandDto;
import fr.insy2s.commerce.models.Command;
import fr.insy2s.commerce.services.ICommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/command")
public class CommandController {

    private final ICommandService commandService;
    @GetMapping("/all")
    public List<CommandDto> getAllCommands(){
        return commandService.getAllCommands();
    }
    @GetMapping("/detail/{id}")
    public CommandDto command(@PathVariable Long id){
        return commandService.findById(id);
    }
    @PostMapping("/add")
    public Command addCommand(@Validated @RequestBody Command command){
        return commandService.addCommand(command);
    }

    @GetMapping("/allArchive")
    public List<CommandDto> getAllCommandWithoutArchive(){
        return commandService.getAllCommandWithoutArchive();
    }
    @GetMapping("/archiveAll")
    public List<CommandDto> getAllArchive(){
        return commandService.getAllArchive();
    }
}
