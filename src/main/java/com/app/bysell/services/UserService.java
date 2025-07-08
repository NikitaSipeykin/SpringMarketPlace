package com.app.bysell.services;

import com.app.bysell.models.User;
import com.app.bysell.models.enums.Role;
import com.app.bysell.repositoryes.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  public boolean createUser(User user){
    String email = user.getEmail();
    if (userRepository.findByEmail(email) != null) return false;
    user.setActive(true);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.getRoles().add(Role.ROLE_USER);
    log.info("Saving new User with email {}", email);
    userRepository.save(user);
    return true;
  }
}
