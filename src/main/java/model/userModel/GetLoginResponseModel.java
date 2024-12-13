package model.userModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetLoginResponseModel {
    private long id;
    private String username;
    private String password;

    private int userStatus;

    public GetLoginResponseModel() {
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public GetLoginResponseModel(long id, String username, String password, int userStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userStatus = userStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }
}
