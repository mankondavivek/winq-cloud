package io.winq.cloud.dto;

import lombok.Data;
import org.bson.types.ObjectId;


@Data
public class UserResponse {

    private ObjectId id;

    private String name;

    private String email;

    private String phoneNumber;

    private boolean isActive;
}
