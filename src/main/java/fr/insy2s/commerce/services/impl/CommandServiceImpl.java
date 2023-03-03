package fr.insy2s.commerce.services.impl;

import fr.insy2s.commerce.dtos.CommandDto;
import fr.insy2s.commerce.models.Command;
import fr.insy2s.commerce.repositories.ICommandRepository;
import fr.insy2s.commerce.services.ICommandService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandServiceImpl implements ICommandService {

    private final ICommandRepository commandRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CommandDto> getAllCommands() {
        return commandRepository.findAll()
                .stream()
                .map(command -> modelMapper.map(command, CommandDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommandDto findById(Long id) {
        Command command = commandRepository.findById(id).orElse(null);
        return modelMapper.map(command,CommandDto.class);
    }

    @Override
    public Command addCommand(Command command) {
        return commandRepository.save(command);
    }

    @Override
    public List<CommandDto> getAllCommandWithoutArchive() {
        return commandRepository.findAllCommandWithoutArchive()
                .stream()
                .map(command -> modelMapper.map(command, CommandDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CommandDto> getAllArchive() {
        return commandRepository.findArchive()
                .stream()
                .map(command -> modelMapper.map(command, CommandDto.class))
                .collect(Collectors.toList());
    }
}
