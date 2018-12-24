package io.winq.cloud.facade.impl;

import io.winq.cloud.converter.UserRequestToUserConverter;
import io.winq.cloud.converter.UserToUserResponseConverter;
import io.winq.cloud.dto.UserResponse;
import io.winq.cloud.dto.request.UserRequest;
import io.winq.cloud.exception.InvalidRequestDataException;
import io.winq.cloud.facade.UserFacade;
import io.winq.cloud.model.User;
import io.winq.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserRequestToUserConverter userRequestToUserConverter;

    @Autowired
    private UserToUserResponseConverter userToUserResponseConverter;

    @Autowired
    private UserService userService;

    @Override
    public UserResponse createUser(UserRequest userRequest) throws InvalidRequestDataException {

        if(userRequest == null){
            throw new NullPointerException("Request Body cannot be null or empty.");
        }

        else if(userRequest.getEmail() == null || StringUtils.isEmpty(userRequest.getEmail())){
            throw new InvalidRequestDataException("Email cannot be null or empty");
        }

        User user = userRequestToUserConverter.convert(userRequest);

        user = userService.createUSer(user);

        UserResponse userResponse = userToUserResponseConverter.convert(user);

        return userResponse;
    }
}

