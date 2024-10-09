package vn.t3h.java_2407_springboot_client.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.t3h.java_2407_springboot_client.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);
    Product findProductById(Long id);
    Page<Product> findAll(Pageable page);
}

