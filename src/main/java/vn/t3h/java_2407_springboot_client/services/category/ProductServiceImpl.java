package vn.t3h.java_2407_springboot_client.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.java_2407_springboot_client.common.Response;
import vn.t3h.java_2407_springboot_client.entities.Product;
import vn.t3h.java_2407_springboot_client.repositories.ProductRepository;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductDetail(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Response create(Product product) {
        Response response = new Response(0, "ERROR", null);
        productRepository.save(product);
        response = new Response(1, "SUCCESS", product);
        return response;
    }
}
