package fr.insy2s.commerce.repositories;

import fr.insy2s.commerce.models.Category;
import fr.insy2s.commerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select * from category where soft_delete = false ;", nativeQuery = true)
    List<Category> findAllCategoryWithoutArchive();

    @Query(value = "select * from category where soft_delete = true ;", nativeQuery = true)
    List<Category> findAllArchive();

/*    @Query("SELECT c.products FROM Category c WHERE c.idCategory = :id")
    List<Product> getByCategory(Long id);*/

}
