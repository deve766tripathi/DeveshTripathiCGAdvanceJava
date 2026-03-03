package in.cg.service;

import in.cg.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, String> users = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getUsername(), user.getPassword());
    }

    public boolean validateUser(User user) {
        String pwd = users.get(user.getUsername());
        return pwd != null && pwd.equals(user.getPassword());
    }
}