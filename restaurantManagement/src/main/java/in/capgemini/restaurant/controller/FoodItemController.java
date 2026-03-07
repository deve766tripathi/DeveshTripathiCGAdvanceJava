package in.capgemini.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.capgemini.restaurant.dto.FoodItemDTO;
import in.capgemini.restaurant.service.FoodItemService;

@RestController
@RequestMapping("/api/restaurants")
public class FoodItemController {

    @Autowired
    private FoodItemService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{restaurantId}/fooditems")
    public FoodItemDTO addFoodItem(
            @PathVariable Long restaurantId,
            @RequestBody FoodItemDTO dto){

        return service.addFoodItem(restaurantId,dto);
    }

    @GetMapping("/{restaurantId}/fooditems")
    public List<FoodItemDTO> getFoodItems(@PathVariable Long restaurantId){

        return service.getFoodItems(restaurantId);
    }
}