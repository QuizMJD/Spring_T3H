package vn.t3h.java_2407_springboot_client.services.category;

import vn.t3h.java_2407_springboot_client.common.Response;
import vn.t3h.java_2407_springboot_client.entities.Category;
import vn.t3h.java_2407_springboot_client.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getProductDetail(Long id);

    Response create(Product product);
}

