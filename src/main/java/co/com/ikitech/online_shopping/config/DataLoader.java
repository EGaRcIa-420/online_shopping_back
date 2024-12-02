package co.com.ikitech.online_shopping.config;

import co.com.ikitech.online_shopping.model.Category;
import co.com.ikitech.online_shopping.model.Product;
import co.com.ikitech.online_shopping.repository.CategoryRepository;
import co.com.ikitech.online_shopping.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
    @Bean
    CommandLineRunner loadData(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return args -> {
            Category electronics = new Category("Electronics");
            Category clothing = new Category("Clothing");

            categoryRepository.save(electronics);
            categoryRepository.save(clothing);

            productRepository.save(new Product("Laptop", 1200.00, electronics));
            productRepository.save(new Product("Smartphone", 800.00, electronics));
            productRepository.save(new Product("T-shirt", 20.00, clothing));

        };
    }
}
