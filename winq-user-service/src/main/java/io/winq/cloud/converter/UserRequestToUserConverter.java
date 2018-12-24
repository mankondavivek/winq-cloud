package io.winq.cloud.converter;

import io.winq.cloud.dto.request.UserRequest;
import io.winq.cloud.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserRequestToUserConverter implements Converter<UserRequest, User> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public User convert(UserRequest source) {
        User user = new User();

        user.setName(source.getName());
        user.setEmail(source.getEmail());
        user.setActive(true);
        user.setCreatedOn(new Date());
        user.setPhoneNumber(source.getPhoneNumber());
        user.setPassword(source.getPassword());

        return user;
    }
}
