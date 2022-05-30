package mobilelele.mobilelele.service;

import mobilelele.mobilelele.model.service.UserServiceModel;

public interface UserService {

    void initializeUsersAndRoles();

    boolean login(UserServiceModel userServiceModel);
}
