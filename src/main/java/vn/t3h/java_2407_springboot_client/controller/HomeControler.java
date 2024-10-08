package vn.t3h.java_2407_springboot_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.t3h.java_2407_springboot_client.entities.Product;
import vn.t3h.java_2407_springboot_client.services.category.CategoryService;
import vn.t3h.java_2407_springboot_client.services.category.ProductService;

//@RestController
@Controller
public class HomeControler {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("test")
    public String test(){
        return "test";
    }

    @GetMapping(value = {"/", "home"})
    public String homPage(Model model, @RequestParam(required = false) String message) {
        model.addAttribute("message", message);
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProduct());
        return "index";
    }
    @GetMapping("/product/{id}")
    public String showDetailProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product",productService.getProductDetail(id));
        return "product/detail";
    }
}
