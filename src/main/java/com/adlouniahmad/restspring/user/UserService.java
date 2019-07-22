package com.adlouniahmad.restspring.user;

import com.adlouniahmad.restspring.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);
}
