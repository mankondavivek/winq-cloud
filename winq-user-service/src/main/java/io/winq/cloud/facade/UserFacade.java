package io.winq.cloud.facade;

import io.winq.cloud.dto.UserResponse;
import io.winq.cloud.dto.request.UserRequest;

public interface UserFacade {
    public UserResponse createUser(UserRequest userRequest);
}
