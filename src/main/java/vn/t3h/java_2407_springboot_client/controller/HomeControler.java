package vn.t3h.java_2407_springboot_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.t3h.java_2407_springboot_client.entities.Product;
import vn.t3h.java_2407_springboot_client.services.category.CategoryService;
import vn.t3h.java_2407_springboot_client.services.product.ProductService;

import java.util.List;
import java.util.Optional;


@Controller
public class HomeControler {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    @GetMapping("/")
    public String homPage(Model model,
                          @RequestParam(required = false) String message,
                          @RequestParam("page")Optional<String> pageOptional,
                          @RequestParam("name") Optional<String> nameOptional) {
        int page = 1;
        try {
            if (pageOptional.isPresent()) {
                page = Integer.parseInt(pageOptional.get());
            }
            else {

            }
        }catch(Exception e){
        }
//        String name=nameOptional.get();
        String name = nameOptional.orElse("");
        Pageable pageable= PageRequest.of(page -1,12);
        Page<Product> products=this.productService.searchProductWithSpec(pageable,name);
        if (products.isEmpty()) {
            products = this.productService.getAllProduct(pageable);
        }
        List<Product> productList=products.getContent();
        model.addAttribute("message", message);
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products",productList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",products.getTotalPages());

        return "index";
    }

    @GetMapping("/product/{id}")
    public String showDetailProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product",productService.getProductDetail(id));

        return "product/detail";
    }
    @GetMapping("/category")
    public String getCategoryPage(Model model,
                                  @RequestParam(required = false) String message,
                                  @RequestParam("page")Optional<String> pageOptional) {
        int page = 1;
        try {
            if (pageOptional.isPresent()) {
                page = Integer.parseInt(pageOptional.get());
            }
            else {

            }
        }catch(Exception e){
        }

        Pageable pageable= PageRequest.of(page -1,12);
        Page<Product> products=this.productService.getAllProduct(pageable);

        List<Product> productList=products.getContent();
        model.addAttribute("message", message);
        model.addAttribute("products",productList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",products.getTotalPages());

        return"category/show";
    }
}
