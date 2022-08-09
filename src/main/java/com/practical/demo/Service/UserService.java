package com.practical.demo.Service;

import com.practical.demo.Entity.User;
import com.practical.demo.Model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerifiactionTokenForUser(String token, User user);
}
