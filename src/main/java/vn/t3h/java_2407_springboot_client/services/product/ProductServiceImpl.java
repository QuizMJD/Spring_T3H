package vn.t3h.java_2407_springboot_client.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.t3h.java_2407_springboot_client.common.Response;
import vn.t3h.java_2407_springboot_client.entities.Product;
import vn.t3h.java_2407_springboot_client.entities.Product_;
import vn.t3h.java_2407_springboot_client.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

//    @Override
//    public List<Product> getAllProduct() {
//        return productRepository.findAll();
//    }

    @Override
    public Page<Product> getAllProduct(Pageable page) {
        return productRepository.findAll(page);
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

    @Override
    public Page<Product> searchProductWithSpec(Pageable page, String name) {
        return this.productRepository.findAll(this.nameLike(name),page);
    }

    @Override
    public Specification<Product> nameLike(String name) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(root.get(Product_.NAME), "%"+name+"%");
    }


}
