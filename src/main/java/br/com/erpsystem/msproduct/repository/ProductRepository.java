package br.com.erpsystem.msproduct.repository;

import br.com.erpsystem.msproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product findProductByName(String name);
}
