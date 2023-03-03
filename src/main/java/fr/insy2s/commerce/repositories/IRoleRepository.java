package fr.insy2s.commerce.repositories;

import fr.insy2s.commerce.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "select * from role where soft_delete = false ;",nativeQuery = true)
    List<Role> findAllRoleWithoutArchive();
    @Query(value = "select * from role where soft_delete = true ;",nativeQuery = true)
    List<Role> findAllArchive();


}
