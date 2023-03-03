package fr.insy2s.commerce.repositories;

import fr.insy2s.commerce.models.LineOfPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILineOfPaymentRepository extends JpaRepository<LineOfPayment,Long> {
}
