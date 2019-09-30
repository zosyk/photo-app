package com.app.discovery.photoappapiusers.service;

import com.app.discovery.photoappapiusers.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService  {

    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailsByEmail(String email);
}
