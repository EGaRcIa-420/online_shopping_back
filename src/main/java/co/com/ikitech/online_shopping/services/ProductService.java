package co.com.ikitech.online_shopping.services;

import co.com.ikitech.online_shopping.dto.ProductDTO;
import co.com.ikitech.online_shopping.model.Product;
import co.com.ikitech.online_shopping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<ProductDTO> getProductById(Long id){
        return productRepository.findById(id).map(this::convertToDTO);
    }

    public ProductDTO createProduct(Product product){
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    public ProductDTO updateProduct(Long id, Product productDetails){
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setStock(productDetails.getStock());
            return productRepository.save(product);
        }).map(this::convertToDTO).orElseThrow(()-> new RuntimeException("Producto no encontrado"));
    }

    public void deleteProduct(Long id) {productRepository.deleteById(id);}

    private ProductDTO convertToDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory() != null ? product.getCategory().getName(): null
        );
    }
}
