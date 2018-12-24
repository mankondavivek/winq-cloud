package io.winq.cloud.facade.impl;

import io.winq.cloud.converter.UserRequestToUserConverter;
import io.winq.cloud.converter.UserToUserResponseConverter;
import io.winq.cloud.dto.UserResponse;
import io.winq.cloud.dto.request.UserRequest;
import io.winq.cloud.exception.InvalidRequestDataException;
import io.winq.cloud.exception.UserAlreadyExists;
import io.winq.cloud.facade.UserFacade;
import io.winq.cloud.model.User;
import io.winq.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserRequestToUserConverter userRequestToUserConverter;

    @Autowired
    private UserToUserResponseConverter userToUserResponseConverter;

    @Autowired
    private UserService userService;

    @Override
    public UserResponse createUser(UserRequest userRequest) throws InvalidRequestDataException, UserAlreadyExists {

        if(userRequest == null){
            throw new NullPointerException("Request Body cannot be null or empty.");
        }

        if(userRequest.getEmail() == null || StringUtils.isEmpty(userRequest.getEmail())){
            throw new InvalidRequestDataException("Email cannot be null or empty");
        }

        if(userRequest.getName() == null || StringUtils.isEmpty(userRequest.getName())){
            throw new InvalidRequestDataException("Name cannot be null or empty");
        }

        if(!isEmailValid(userRequest.getEmail())){
            throw new InvalidRequestDataException("Invalid Email Id");
        }

        if(!isNameValid(userRequest.getName()) && userRequest.getName().length() > 3){

        }

        User user = userRequestToUserConverter.convert(userRequest);

        user = userService.createUSer(user);

        UserResponse userResponse = userToUserResponseConverter.convert(user);

        return userResponse;
    }

    private boolean isNameValid(String name) {

        String nameRegex = "^[\\p{L} .'-]+$";

        Pattern pattern = Pattern.compile(nameRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

    private boolean isEmailValid(String email) {

        String emailRegex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}

