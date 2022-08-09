package com.practical.demo.Service;

import com.practical.demo.Entity.User;
import com.practical.demo.Entity.VerifcationToken;
import com.practical.demo.Model.UserModel;
import com.practical.demo.Repository.UserRepository;
import com.practical.demo.Repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(UserModel userModel) {

        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRole("USER");
        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerifiactionTokenForUser(String token, User user) {
        VerifcationToken verifcationToken = new VerifcationToken(token,user);
        verificationTokenRepository.save(verifcationToken);
    }
}
