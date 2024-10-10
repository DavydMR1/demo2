package com.example.demo2.controllers;

import com.example.demo2.models.Product;
import com.example.demo2.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/products")
    private String getProducts(Model model) {
        model.addAttribute("Products", productService.getProducts());
        return "products";
    }

    @PostMapping("products")
    public String addProduct(Product p, Model model) {
        productService.addProduct(p);
        model.addAttribute("products", productService.getProducts());
        return "products";
    }
}
