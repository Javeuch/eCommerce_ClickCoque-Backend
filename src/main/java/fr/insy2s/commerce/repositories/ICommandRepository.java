package fr.insy2s.commerce.repositories;

import fr.insy2s.commerce.models.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommandRepository extends JpaRepository<Command, Long> {
    @Query(value = "select * from command where soft_delete = false ;",nativeQuery = true)
    List<Command> findAllCommandWithoutArchive();
    @Query(value = "select * from command where soft_delete = true ;",nativeQuery = true)
    List<Command> findArchive();
}
