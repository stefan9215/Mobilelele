package mobilelele.mobilelele.service.impl;

import mobilelele.mobilelele.model.entity.User;
import mobilelele.mobilelele.model.entity.UserRole;
import mobilelele.mobilelele.model.entity.enums.Role;
import mobilelele.mobilelele.repository.UserRepository;
import mobilelele.mobilelele.repository.UserRoleRepository;
import mobilelele.mobilelele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
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
