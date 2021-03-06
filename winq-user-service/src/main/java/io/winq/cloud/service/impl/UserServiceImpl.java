package io.winq.cloud.service.impl;

import io.winq.cloud.exception.UserAlreadyExistsException;
import io.winq.cloud.model.User;
import io.winq.cloud.repository.UserRepository;
import io.winq.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUSer(User user) throws UserAlreadyExistsException {

        if(userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException("Email Id already registered.");
        }

        User response= userRepository.save(user);

        return response;
    }
}
