package mobilelele.mobilelele.service;

import mobilelele.mobilelele.model.binding.UserRegisterBindingModel;
import mobilelele.mobilelele.model.service.UserLoginServiceModel;
import mobilelele.mobilelele.model.service.UserRegisterServiceModel;

public interface UserService {

    void logout();

    void initializeUsersAndRoles();

    boolean login(UserLoginServiceModel userLoginServiceModel);

    boolean registerUser(UserRegisterServiceModel userRegisterServiceModel);
}
