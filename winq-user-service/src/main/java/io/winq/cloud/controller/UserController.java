package io.winq.cloud.controller;

import io.winq.cloud.dto.request.UserRequest;
import com.winq.cloud.dto.request.UserUpdateRequest;
import io.winq.cloud.dto.UserResponse;
import io.winq.cloud.exception.InvalidRequestDataException;
import io.winq.cloud.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/greet")
    public ResponseEntity<?> greet(){

        String hello = "Hey!! It works. Brilliant Stuff.";
        return ResponseEntity.ok(hello);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) throws InvalidRequestDataException {

        UserResponse userResponse = userFacade.createUser(userRequest);

        return ResponseEntity.ok(userResponse);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateRequest userUpdateRequest){

        return null;
    }

    public ResponseEntity<?> forgotPassword(){

        return null;
    }

    public ResponseEntity<?> resetPassword(){

        return null;
    }

    @GetMapping("/")
    public ResponseEntity<?> generateQuiz(){

        return null;
    }
}
