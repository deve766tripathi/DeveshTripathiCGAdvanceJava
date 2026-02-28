package in.cg.shoppingCart.controller;

import in.cg.shoppingCart.model.Product;
import in.cg.shoppingCart.service.CartService;
import in.cg.shoppingCart.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    // ✅ View Products
    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    // ✅ Add to Cart
    @PostMapping("/addToCart")
    public String addToCart(
            @RequestParam("productId") int productId,
            @RequestParam("quantity") int quantity,
            Model model) {

        Product product = productService.getProductById(productId);
        cartService.addToCart(product, quantity);

        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotalAmount());

        return "cart";
    }

    // ✅ View Cart
    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotalAmount());
        return "cart";
    }
}