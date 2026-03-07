package in.capgemini.restaurant.service;

import org.springframework.data.domain.Page;

import in.capgemini.restaurant.dto.RestaurantDTO;

public interface RestaurantService {

    Page<RestaurantDTO> getAllRestaurants(int page,int size);

    RestaurantDTO addRestaurant(RestaurantDTO dto);
}