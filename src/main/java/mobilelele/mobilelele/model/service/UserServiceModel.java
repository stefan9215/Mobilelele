package mobilelele.mobilelele.model.service;

import mobilelele.mobilelele.model.binding.UserBindingModel;

public class UserServiceModel {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
