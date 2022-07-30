package in.reqres.api.convert.json.string.service.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import in.reqres.api.convert.json.string.config.RequestResConfigData;
import in.reqres.api.convert.json.string.model.api.request.DataRequest;
import in.reqres.api.convert.json.string.model.api.request.UserRequest;
import in.reqres.api.convert.json.string.model.api.response.UserResponse;
import in.reqres.api.convert.json.string.service.UserService;
import in.reqres.api.convert.json.string.util.Constants;
import in.reqres.api.convert.json.string.util.UserUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    private final RequestResConfigData requestResConfigData;

    public UserServiceImpl(RestTemplate restTemplate, RequestResConfigData requestResConfigData) {
        this.restTemplate = restTemplate;
        this.requestResConfigData = requestResConfigData;
    }

    @Override
    public UserResponse getUsers() throws IllegalAccessException {
        UserRequest users = restTemplate.getForObject(requestResConfigData.getUrlRequest(),
                UserRequest.class);

        List<DataRequest> dataRequests = users.getData();

        List<String> dataListString = new ArrayList<>();

        for (DataRequest data : dataRequests) {
            Field[] fields = data.getClass().getDeclaredFields();

            extractedField(dataListString, data, fields);
        }

        return new UserResponse(dataListString);
    }

    private void extractedField(List<String> dataListString, DataRequest data, Field[] fields)
            throws IllegalAccessException {
        String result = "";

        for(Field field : fields) {
            field.setAccessible(true);
            String nameField = getNameField(field);

            if (Constants.FIELDS.contains(nameField)) {

                String value = field.getType() == Long.class ?
                        ((Long) field.get(data)).toString()
                        : field.get(data).toString();

                result = result + UserUtil.convertFieldsToString(nameField, value);
            }
        }
        dataListString.add(result);
    }

    private String getNameField(Field field) {
        String nameField = "";

        if (field.isAnnotationPresent(JsonProperty.class)) {
            JsonProperty annotation = field.getAnnotation(JsonProperty.class);
            nameField = annotation.value();
        } else {
            nameField = field.getName();
        }

        return nameField;
    }
}
