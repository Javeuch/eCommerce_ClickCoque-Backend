package fr.insy2s.commerce.controllers;

import fr.insy2s.commerce.dtos.TagDto;
import fr.insy2s.commerce.models.Tag;
import fr.insy2s.commerce.services.ITagService;
import fr.insy2s.commerce.services.impl.TagServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/tag")
public class TagController {
    private final TagServiceImpl tagService;

    @GetMapping("/all")
    public List<TagDto> getAllTags(){
        return tagService.getAllTags();
    }

    @GetMapping("/detail/{id}")
    public TagDto tag(@PathVariable Long id){
        return tagService.findById(id);
    }

    @PostMapping("/add")
    public Tag addTag(@Validated @RequestBody TagDto tag){
        return tagService.addTag(tag);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTag(@PathVariable Long id){
        tagService.deleteTag(id);
    }
}
