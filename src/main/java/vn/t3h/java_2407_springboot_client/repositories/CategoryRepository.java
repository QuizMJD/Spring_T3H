package vn.t3h.java_2407_springboot_client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.t3h.java_2407_springboot_client.entities.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByName(String name);
}
