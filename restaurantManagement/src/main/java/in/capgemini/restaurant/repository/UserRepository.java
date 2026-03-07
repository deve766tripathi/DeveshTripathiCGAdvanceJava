package in.capgemini.restaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.capgemini.restaurant.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);
}