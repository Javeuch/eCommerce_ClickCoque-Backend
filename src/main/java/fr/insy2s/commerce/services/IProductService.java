package fr.insy2s.commerce.services;

import fr.insy2s.commerce.dtos.ProductDto;
import fr.insy2s.commerce.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IProductService {

    List<ProductDto> getAllProducts();

    List<ProductDto> getAll();

    ProductDto findById(Long id);

    Product addProduct(Product product);

    List<ProductDto> getAllArchive();

    void deleteProduct(Long id);

    // Fetch all cases
    List<ProductDto> getAllCases();

    /**
     * @author Maxime
     * Fetch Favorite Products
     */
    List<ProductDto> getFavoriteWithoutArchive();

    /**
     * Fetch Recent Products
     */
    List<ProductDto> getRecentWithoutArchive();

    /**
     * Fetch Accessories (Products)
     */
    /*    List<ProductDto> getByCategory(Long id);*/

    /**
     * Pagination & Sorting
     */
    // Fetch products by category
    Page<Product> getByCategoryPaginated(Long idCategory, Pageable pageable);

    // Fetch products by brand and category
    Page<Product> getByBrandPaginated(Long idCategory, Long brandId, Pageable pageable);
}

