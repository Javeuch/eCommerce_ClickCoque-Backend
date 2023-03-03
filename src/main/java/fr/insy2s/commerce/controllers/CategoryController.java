package fr.insy2s.commerce.controllers;

import fr.insy2s.commerce.dtos.CategoryDto;
import fr.insy2s.commerce.models.Category;
import fr.insy2s.commerce.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/category")
public class CategoryController {
    private final ICategoryService categoryService;
    @GetMapping("/all")
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/detail/{id}")
    public CategoryDto category(@PathVariable Long id){
        return categoryService.findById(id);
    }
    @PostMapping("/add")
    public Category addCategory(@Validated @RequestBody Category category){
        return categoryService.addCategory(category);
    }
    @GetMapping("/allArchive")
    public List<CategoryDto> getAllCategoryWithoutArchive(){
        return categoryService.getAllCategoryWithoutArchive();
    }
    @GetMapping("/archiveAll")
    public List<CategoryDto> getAllArchive(){
        return categoryService.getAllArchive();
    }

}
