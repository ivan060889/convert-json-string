package in.reqres.api.convert.json.string.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.reqres.api.convert.json.string.model.api.request.UserRequest;
import in.reqres.api.convert.json.string.model.api.response.UserResponse;

import java.io.File;
import java.io.IOException;

public class DataFactory {

    public static final String URL_API_USERS = "https://reqres.in/api/users";
    public static final String URL_API__CONTROLLER = "/api/users";

    public static UserRequest readRequest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/test/resources/user-data.json"),
                UserRequest.class);
    }

    public static UserResponse readData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/test/resources/data-string.json"),
                UserResponse.class);
    }

    public static UserResponse convertStringToUserResponse(String json) throws IOException {
        return new ObjectMapper().readValue(json, UserResponse.class);
    }
}
