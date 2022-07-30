package in.reqres.api.convert.json.string.model.api.response;

import java.util.List;

public class UserResponse {

    private List<String> data;

    public UserResponse() {
    }

    public UserResponse(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
