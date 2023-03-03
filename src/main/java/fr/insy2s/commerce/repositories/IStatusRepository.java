package fr.insy2s.commerce.repositories;

import fr.insy2s.commerce.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends JpaRepository<Status,Long> {

}
