package in.reqres.api.convert.json.string.controller;

import in.reqres.api.convert.json.string.factory.DataFactory;
import in.reqres.api.convert.json.string.model.api.response.UserResponse;
import in.reqres.api.convert.json.string.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    private MockMvc mockMvc;

    private UserResponse userResponse;

    @BeforeEach
    void setUp() throws IOException {
        userResponse = DataFactory.readData();

        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .build();
    }

    @Test
    @DisplayName("get users")
    void getUsers() throws Exception {

        when(userService.getUsers()).thenReturn(userResponse);


        MvcResult mvcResult = mockMvc.perform(get(DataFactory.URL_API__CONTROLLER))
                .andExpect(status().isOk())
                .andReturn();

        UserResponse userR = DataFactory.convertStringToUserResponse(
                mvcResult.getResponse().getContentAsString());

        assertEquals(userResponse.getData(), userR.getData());

        verify(userService).getUsers();
    }
}