package vn.t3h.java_2407_springboot_client.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.java_2407_springboot_client.common.Response;
import vn.t3h.java_2407_springboot_client.entities.Category;
import vn.t3h.java_2407_springboot_client.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Response create(Category category) {
        Response response = new Response(0, "ERROR", null);
        categoryRepository.save(category);
        response = new Response(1, "SUCCESS", category);
        return response;
    }
}
