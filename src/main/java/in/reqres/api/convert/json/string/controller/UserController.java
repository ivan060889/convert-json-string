package in.reqres.api.convert.json.string.controller;

import in.reqres.api.convert.json.string.model.api.response.UserResponse;
import in.reqres.api.convert.json.string.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public UserResponse getUsers() throws IllegalAccessException {
        return userService.getUsers();
    }
}
