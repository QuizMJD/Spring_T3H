package vn.t3h.java_2407_springboot_client.services.category;


import vn.t3h.java_2407_springboot_client.common.Response;
import vn.t3h.java_2407_springboot_client.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    Response create(Category category);
}
