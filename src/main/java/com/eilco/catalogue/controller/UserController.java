package com.eilco.catalogue.controller;

import com.eilco.catalogue.model.ShoppingCart;
import com.eilco.catalogue.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
//@CrossOrigin(origins = "http://localhost:4200") // the annotation enables Cross-Origin Resource Sharing (CORS) on the server.
// This step isn't always necessary. Since we are deploying our Angular frontend to http://localhost:4200 and our Boot backend to http://localhost:8080, the browser would otherwise deny requests from one to the other.
public class UserController {

    private ShoppingCartService shoppingCartService;

    @Autowired
    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("user/orderHistory")
    public String cartHistory(Principal principal, Model model){
        List<ShoppingCart> shoppingCarts = shoppingCartService.getCompletedCarts(principal.getName(),true);
        if(shoppingCarts == null){
            model.addAttribute("noOrdersYet", "No completed orders for you yet!");
        }
        model.addAttribute("carts", shoppingCarts);
        return "user/orderHistory";
    }

    @GetMapping("user/viewOrdered/{id}")
    public String viewOrder(@PathVariable("id")Long id, Model model){
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(id);
        model.addAttribute("order", shoppingCart);
        return "user/orderHistory";
    }
}