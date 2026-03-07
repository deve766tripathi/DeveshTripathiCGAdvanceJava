package in.capgemini.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.capgemini.restaurant.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

}