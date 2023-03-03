package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.CommandDto;
import fr.insy2s.commerce.models.Command;

import java.util.List;

public interface ICommandService {
    List<CommandDto> getAllCommands();

    CommandDto findById(Long id);

    Command addCommand(Command command);

    List<CommandDto> getAllCommandWithoutArchive();

    List<CommandDto> getAllArchive();
}
