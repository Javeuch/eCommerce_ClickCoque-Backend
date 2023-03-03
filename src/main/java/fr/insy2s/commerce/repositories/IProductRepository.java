package fr.insy2s.commerce.repositories;

import fr.insy2s.commerce.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select * from product where soft_delete = false ", nativeQuery = true)
    List<Product> findAllWithoutArchive();

    @Query(value = "select * from product where soft_delete = true ", nativeQuery = true)
    List<Product> findAllArchive();

    // Fetch all cases
    @Query(value = "select * from product where category_id = 1", nativeQuery = true)
    List<Product> findAllCases();

    /**
     * Fetch Favorite Products (category_id = 1 - "cases")
     * DESC sort in descending order (from Max to Min)
     * LIMIT to constrain the number of returned rows: 8
     */
    @Query(value = "SELECT * FROM product " +
            "       WHERE soft_delete = false " +
            "       AND category_id=1" +
            "       ORDER BY average_notation DESC " +
            "       LIMIT 8;"
            , nativeQuery = true)
    List<Product> findFavoriteWithoutArchive();

    List<Product> findByNameIgnoreCaseContaining(String search);

    /**
     * Fetch Recent Products (category_id = 1 - "cases")
     * DESC sort in descending order (from Newest to Oldest)
     * LIMIT to constrain the number of returned rows: 8
     */
    @Query(value = "SELECT * FROM product " +
            "       WHERE soft_delete = false " +
            "       AND category_id=1" +
            "       ORDER BY date_of_insert DESC " +
            "       LIMIT 8;"
            , nativeQuery = true)
    List<Product> findRecentWithoutArchive();

    /**
     * Pagination & Sorting
     * Find products by category (1:case ; 2:accessories)
     */
    Page<Product> findByCategory_IdCategory(Long idCategory, Pageable pageable);

    // Find products by brand & category (brandId from 1 to 12)
    Page<Product> findByCategory_IdCategoryAndBrand_BrandId(Long idCategory, Long brandId, Pageable pageable);

}
