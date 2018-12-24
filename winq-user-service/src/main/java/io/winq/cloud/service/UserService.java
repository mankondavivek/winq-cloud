package io.winq.cloud.service;

import io.winq.cloud.exception.UserAlreadyExistsException;
import io.winq.cloud.model.User;

public interface UserService {
    User createUSer(User user) throws UserAlreadyExistsException;
}
