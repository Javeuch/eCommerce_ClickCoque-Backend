package fr.insy2s.commerce.services.impl;

import fr.insy2s.commerce.dtos.ProductDto;
import fr.insy2s.commerce.models.Product;
import fr.insy2s.commerce.repositories.ICategoryRepository;
import fr.insy2s.commerce.repositories.IProductRepository;
import fr.insy2s.commerce.services.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return modelMapper.map(product, ProductDto.class);
    }

    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDto = productRepository.findAllWithoutArchive()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
        return productDto;
    }

    @Override
    public List<ProductDto> getAllArchive() {
        return productRepository.findAllArchive()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Fetch all cases
    @Override
    public List<ProductDto> getAllCases() {
        return productRepository.findAllCases()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }
    // Fetch Favorite Products

    @Override
    public List<ProductDto> getFavoriteWithoutArchive() {
        return productRepository.findFavoriteWithoutArchive()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public List<ProductDto> getProductsWithSearch(String search) {
        return productRepository.findByNameIgnoreCaseContaining(search)
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    // Fetch Recent Products
    @Override
    public List<ProductDto> getRecentWithoutArchive() {
        return productRepository.findRecentWithoutArchive()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    // Fetch products by category (used for accessories)
    @Override
    public Page<Product> getByCategoryPaginated(Long id, Pageable pageable) {
        return productRepository.findByCategory_IdCategory(id, pageable);
    }

    // Fetch products by brand and category
    @Override
    public Page<Product> getByBrandPaginated(Long idCategory, Long brandId, Pageable pageable) {
        return productRepository.findByCategory_IdCategoryAndBrand_BrandId(idCategory, brandId, pageable);
    }

}
