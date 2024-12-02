package co.com.ikitech.online_shopping.repository;

import co.com.ikitech.online_shopping.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
