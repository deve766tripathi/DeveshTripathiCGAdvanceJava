package in.capgemini.restaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.capgemini.restaurant.dto.RestaurantDTO;
import in.capgemini.restaurant.entity.Restaurant;
import in.capgemini.restaurant.repository.RestaurantRepository;
import in.capgemini.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<RestaurantDTO> getAllRestaurants(int page, int size) {

        Page<Restaurant> restaurants = repo.findAll(PageRequest.of(page, size));

        return restaurants.map(r -> mapper.map(r, RestaurantDTO.class));
    }

    @Override
    public RestaurantDTO addRestaurant(RestaurantDTO dto) {

        Restaurant restaurant = mapper.map(dto, Restaurant.class);

        Restaurant saved = repo.save(restaurant);

        return mapper.map(saved, RestaurantDTO.class);
    }
}