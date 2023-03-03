package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.CategoryDto;
import fr.insy2s.commerce.models.Category;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> getAllCategories();

    CategoryDto findById(Long id);

    Category addCategory(Category category);

    List<CategoryDto> getAllCategoryWithoutArchive();

    List<CategoryDto> getAllArchive();
}
