package mobilelele.mobilelele.service.impl;

import mobilelele.mobilelele.model.entity.User;
import mobilelele.mobilelele.model.entity.UserRole;
import mobilelele.mobilelele.model.entity.enums.Role;
import mobilelele.mobilelele.model.service.UserLoginServiceModel;
import mobilelele.mobilelele.model.service.UserRegisterServiceModel;
import mobilelele.mobilelele.repository.UserRepository;
import mobilelele.mobilelele.repository.UserRoleRepository;
import mobilelele.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        Optional<User> user = userRepository.findByUsername(userLoginServiceModel.getUsername());
        boolean loginSuccessful = false;

        if (user.isPresent()) {
            loginSuccessful = passwordEncoder.matches(userLoginServiceModel.getPassword(), user.get().getPassword());
        }
        return loginSuccessful;
    }

    @Override
    public boolean registerUser(UserRegisterServiceModel userRegisterServiceModel) {
        Optional<User> existingUser = userRepository.findByUsername(userRegisterServiceModel.getUsername());

        if (existingUser.isPresent()) {
            return false;
        }
        Optional<UserRole> userRole = userRoleRepository.findByRole(Role.USER);
        User userToRegister = modelMapper.map(userRegisterServiceModel, User.class);

        userToRegister
                .setPassword(passwordEncoder.encode(userToRegister.getPassword()))
                .setActive(true)
                .setRoles(List.of(userRole.get()));

        userRepository.save(userToRegister);

        return true;
    }

    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    private void initializeUsers() {

        if (userRepository.count() == 0) {
            Optional<UserRole> adminRole = userRoleRepository.findByRole(Role.ADMIN);
            Optional<UserRole> userRole = userRoleRepository.findByRole(Role.USER);

            User admin = new User()
                    .setUsername("admin")
                    .setPassword(passwordEncoder.encode("admin"))
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setActive(true)
                    .setRoles(List.of(adminRole.get(), userRole.get()));

            User pesho = new User()
                    .setUsername("pesho")
                    .setPassword(passwordEncoder.encode("pesho"))
                    .setFirstName("Pesho")
                    .setLastName("Peshov")
                    .setActive(true)
                    .setRoles(List.of(userRole.get()));

            userRepository.saveAll(List.of(admin, pesho));
        }
    }

    private void initializeRoles() {
        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole()
                    .setRole(Role.ADMIN);

            UserRole userRole = new UserRole()
                    .setRole(Role.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }
}
