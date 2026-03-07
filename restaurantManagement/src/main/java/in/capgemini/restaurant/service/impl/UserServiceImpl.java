package in.capgemini.restaurant.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.capgemini.restaurant.dto.UserDTO;
import in.capgemini.restaurant.entity.User;
import in.capgemini.restaurant.repository.UserRepository;
import in.capgemini.restaurant.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User registerUser(UserDTO dto) {

        User user = mapper.map(dto, User.class);

        user.setPassword(encoder.encode(dto.getPassword()));

        return repo.save(user);
    }
}