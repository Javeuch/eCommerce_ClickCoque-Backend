package fr.insy2s.commerce.services.impl;

import fr.insy2s.commerce.dtos.TagDto;
import fr.insy2s.commerce.models.Tag;
import fr.insy2s.commerce.repositories.ITagRepository;
import fr.insy2s.commerce.services.ITagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TagServiceImpl implements ITagService {

    private final ITagRepository tagRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TagDto> getAllTags() {
        return tagRepository.findAll()
                .stream()
                .map(tag -> modelMapper.map(tag, TagDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TagDto findById(Long id) {
        Tag tag = tagRepository.findById(id).orElse(null);
        return modelMapper.map(tag,TagDto.class);
    }

    @Override
    public Tag addTag(TagDto tag) {
        return tagRepository.save(modelMapper.map(tag, Tag.class));
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
