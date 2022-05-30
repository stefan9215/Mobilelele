package mobilelele.mobilelele.service.impl;

import mobilelele.mobilelele.model.entity.User;
import mobilelele.mobilelele.model.entity.UserRole;
import mobilelele.mobilelele.model.entity.enums.Role;
import mobilelele.mobilelele.repository.UserRepository;
import mobilelele.mobilelele.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initializeUsers() {

        if (userRepository.count() == 0) {
            UserRole userRole = new UserRole();
            User admin = new User()
                    .setUsername("admin")
                    .setFirstName("admin")
                    .setLastName("adminov")
                    .setPassword(passwordEncoder.encode("123456"))
                    .setActive(true)
                    .setRole(List.of(userRole.setRole(Role.ADMIN), userRole.setRole(Role.USER)));

            User pesho = new User()
                    .setUsername("pesho")
                    .setFirstName("Peter")
                    .setLastName("Petrov")
                    .setPassword(passwordEncoder.encode("123456"))
                    .setActive(true)
                    .setRole(List.of(userRole.setRole(Role.USER)));

            userRepository.saveAll(List.of(admin, pesho));
        }
    }
}
