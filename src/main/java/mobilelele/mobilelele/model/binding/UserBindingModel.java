package mobilelele.mobilelele.model.binding;

public class UserBindingModel {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public UserBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
