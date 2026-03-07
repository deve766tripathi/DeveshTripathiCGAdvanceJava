package in.capgemini.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

import in.capgemini.restaurant.dto.RestaurantDTO;
import in.capgemini.restaurant.service.RestaurantService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping
    public Page<RestaurantDTO> getRestaurants(
            @RequestParam int page,
            @RequestParam int size){

        return service.getAllRestaurants(page,size);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public RestaurantDTO addRestaurant(@Valid @RequestBody RestaurantDTO dto){

        return service.addRestaurant(dto);
    }
}
