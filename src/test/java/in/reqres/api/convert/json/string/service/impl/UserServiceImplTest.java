package in.reqres.api.convert.json.string.service.impl;

import in.reqres.api.convert.json.string.config.RequestResConfigData;
import in.reqres.api.convert.json.string.factory.DataFactory;
import in.reqres.api.convert.json.string.model.api.request.UserRequest;
import in.reqres.api.convert.json.string.model.api.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserRequest userRequest;
    private UserResponse userResponse;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private RequestResConfigData requestResConfigData;

    @BeforeEach
    void setUp() throws IOException  {
        userRequest = DataFactory.readRequest();
        userResponse = DataFactory.readData();
    }

    @Test
    @DisplayName("when service have data then convert json to string")
    void whenServiceHaveDataThenConvertJsonToString() throws IllegalAccessException {
        when(requestResConfigData.getUrlRequest())
                .thenReturn(DataFactory.URL_API_USERS);

        when(restTemplate.getForObject(requestResConfigData.getUrlRequest(), UserRequest.class))
                .thenReturn(userRequest);

        UserResponse userR = userService.getUsers();

        assertEquals(6, userRequest.getData().size());
        assertEquals(userResponse.getData(), userR.getData());
    }

}