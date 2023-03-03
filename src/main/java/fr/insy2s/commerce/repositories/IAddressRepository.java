package fr.insy2s.commerce.repositories;

import fr.insy2s.commerce.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "select * from address where soft_delete = false ;",nativeQuery = true)
    List<Address> findAllWithoutArchive();
    @Query(value = "select * from address where soft_delete = true ;",nativeQuery = true)
    List<Address> findArchive();
}
