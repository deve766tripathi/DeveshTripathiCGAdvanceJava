package in.capgemini.restaurant.service;

import java.util.List;

import in.capgemini.restaurant.dto.FoodItemDTO;

public interface FoodItemService {

    FoodItemDTO addFoodItem(Long restaurantId,FoodItemDTO dto);

    List<FoodItemDTO> getFoodItems(Long restaurantId);
}