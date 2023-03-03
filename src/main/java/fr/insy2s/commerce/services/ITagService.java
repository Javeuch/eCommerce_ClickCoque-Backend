package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.TagDto;
import fr.insy2s.commerce.models.Tag;

import java.util.List;

public interface ITagService {
    List<TagDto> getAllTags();

    TagDto findById(Long id);

    Tag addTag(TagDto tag);

    void deleteTag(Long id);
}
