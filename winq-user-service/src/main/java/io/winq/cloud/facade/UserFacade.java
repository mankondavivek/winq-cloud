package io.winq.cloud.facade;

import io.winq.cloud.dto.UserResponse;
import io.winq.cloud.dto.request.UserRequest;
import io.winq.cloud.exception.InvalidRequestDataException;
import io.winq.cloud.exception.UserAlreadyExistsException;

public interface UserFacade {
    public UserResponse createUser(UserRequest userRequest) throws InvalidRequestDataException, UserAlreadyExistsException;
}
