package fr.formation.spring.spring.start.repository;

import fr.formation.spring.spring.start.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.price>:price")
    public List<Product> findProductsWithPriceGreaterThan(@Param("price") Double price);

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) AND p.creationDate < :date")
    public List<Product> findProductsByNameContainingIgnoreCaseAndCreationDateBefore (@Param("name") String name, @Param("creationDate")Date creationDate);

    @Query("SELECT p FROM Product p WHERE p.price = (SELECT MAX(p2.price) FROM Product p2)")
    Optional<Product> findMostExpensiveProduct();

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price = p.price * (1 + :percentage / 100.0)")
    int increasePriceByPercentage(@Param("percentage") Double percentage);
}
