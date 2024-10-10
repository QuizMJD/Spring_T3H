package vn.t3h.java_2407_springboot_client.services.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import vn.t3h.java_2407_springboot_client.common.Response;
import vn.t3h.java_2407_springboot_client.entities.Category;
import vn.t3h.java_2407_springboot_client.entities.Product;

import java.util.List;

public interface ProductService {
    Page<Product> getAllProduct(Pageable page);

    Product getProductDetail(Long id);

    Response create(Product product);
    public Page<Product> searchProductWithSpec(Pageable page,String name);
    public Specification<Product> nameLike(String name);

}
