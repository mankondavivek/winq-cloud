package io.winq.cloud.converter;

import io.winq.cloud.dto.UserResponse;
import io.winq.cloud.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserResponseConverter implements Converter<User, UserResponse> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public UserResponse convert(User source) {

        UserResponse userResponse = new UserResponse();

        userResponse.setId(source.getId());
        userResponse.setName(source.getName());
        userResponse.setEmail(source.getEmail());
        userResponse.setPhoneNumber(source.getPhoneNumber());
        userResponse.setActive(source.isActive());

        return userResponse;
    }
}
