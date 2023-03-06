package fr.insy2s.commerce.controllers;

import fr.insy2s.commerce.dtos.ProductDto;
import fr.insy2s.commerce.models.Product;
import fr.insy2s.commerce.repositories.ICategoryRepository;
import fr.insy2s.commerce.services.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/product")
public class ProductController {
    private final ProductServiceImpl productService;
    private final ICategoryRepository categoryRepository;

    /* Get all with archive */
    @GetMapping("/allAll")
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    /* Get all without Archive */
    @GetMapping("/all")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    /* Get with Search */
    @GetMapping("")
    public List<ProductDto> getProductsWithSearch(@RequestParam(name = "search") String search) {
        return productService.getProductsWithSearch(search);
    }

    /**
     * @author Maxime
     * Fetch favorite/recent/accessory products methods
     */
    // Fetch all cases
    @GetMapping("/cases")
    public List<ProductDto> getAllCases() {
        return productService.getAllCases();
    }

    // Fetch favorite products
    @GetMapping("/favorite")
    public List<ProductDto> getFavoriteWithoutArchive() {
        return productService.getFavoriteWithoutArchive();
    }

    // Fetch recent products
    @GetMapping("/recent")
    public List<ProductDto> getRecentWithoutArchive() {
        return productService.getRecentWithoutArchive();
    }

    // Fetch paginated accessories
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable("id") Long id, Pageable pageable) {
        return ResponseEntity.ok(productService.getByCategoryPaginated(id, pageable).getContent());
    }

    // Fetch products by brand & category
    @GetMapping("/brand/{idCategory}/{brandId}")
    public ResponseEntity<List<Product>> getProductByBrandId(@PathVariable("idCategory") Long idCategory,
                                                             @PathVariable("brandId") Long brandId,
                                                             Pageable pageable) {
        return ResponseEntity.ok(productService.getByBrandPaginated(idCategory, brandId, pageable).getContent());
    }

    /*Get all Archive */
    @GetMapping("/archive")
    public List<ProductDto> getAllArchive() {
        return productService.getAllArchive();
    }

    @GetMapping("/detail/{id}")
    public ProductDto product(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@Validated @RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
