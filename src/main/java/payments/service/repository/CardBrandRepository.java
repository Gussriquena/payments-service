package payments.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import payments.service.domain.model.CardBrand;

@Repository
public interface CardBrandRepository extends JpaRepository<CardBrand, Long> {
}
