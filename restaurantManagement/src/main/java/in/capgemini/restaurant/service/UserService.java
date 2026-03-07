package in.capgemini.restaurant.service;

import in.capgemini.restaurant.dto.UserDTO;
import in.capgemini.restaurant.entity.User;

public interface UserService {

    User registerUser(UserDTO dto);
}