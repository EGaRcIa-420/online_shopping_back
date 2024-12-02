package co.com.ikitech.online_shopping.repository;

import co.com.ikitech.online_shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

