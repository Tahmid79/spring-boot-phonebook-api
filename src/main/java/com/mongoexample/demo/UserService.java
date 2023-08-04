package com.mongoexample.demo;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String userId);
    boolean deleteUserById(String userId);
    boolean addUser(User user);
    boolean updateUser(String userId, User user);
}
