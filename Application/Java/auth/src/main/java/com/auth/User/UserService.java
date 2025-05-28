package com.auth.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean createUser(User user);
    boolean deleteUser(String email);
    boolean updateUser(User user);
}
