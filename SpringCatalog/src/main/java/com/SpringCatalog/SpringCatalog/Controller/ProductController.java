package com.SpringCatalog.SpringCatalog.Controller;

import com.SpringCatalog.SpringCatalog.Entity.Product;
import com.SpringCatalog.SpringCatalog.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/displayProducts")
    public String displayProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "display";
    }

    @GetMapping("/productsByCategory/{category}")
    public String productsByCategory(@PathVariable String category, Model model) {
        List<Product> products = productService.getProductsByCategory(category);
        model.addAttribute("products", products);
        return "display";
    }
}