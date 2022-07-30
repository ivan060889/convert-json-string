package in.reqres.api.convert.json.string.model.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataRequest {

    private Long id;

    @JsonProperty(value = "last_name")
    private String lastName;

    private String email;

    @JsonProperty(value = "first_name")
    private String firstName;

    private String avatar;

    public DataRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DataRequest{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", avatar='").append(avatar).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
