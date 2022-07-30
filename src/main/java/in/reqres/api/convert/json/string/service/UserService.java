package in.reqres.api.convert.json.string.service;

import in.reqres.api.convert.json.string.model.api.response.UserResponse;

public interface UserService {

    UserResponse getUsers() throws IllegalAccessException;
}
