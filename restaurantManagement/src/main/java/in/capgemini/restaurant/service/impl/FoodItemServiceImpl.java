package in.capgemini.restaurant.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.capgemini.restaurant.dto.FoodItemDTO;
import in.capgemini.restaurant.entity.FoodItem;
import in.capgemini.restaurant.repository.FoodItemRepository;
import in.capgemini.restaurant.service.FoodItemService;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public FoodItemDTO addFoodItem(Long restaurantId, FoodItemDTO dto) {

        FoodItem item = mapper.map(dto, FoodItem.class);

        item.setRestaurantId(restaurantId);

        FoodItem saved = repo.save(item);

        return mapper.map(saved, FoodItemDTO.class);
    }

    @Override
    public List<FoodItemDTO> getFoodItems(Long restaurantId) {

        List<FoodItem> items = repo.findByRestaurantId(restaurantId);

        return items.stream()
                .map(item -> mapper.map(item, FoodItemDTO.class))
                .collect(Collectors.toList());
    }
}