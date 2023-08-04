package com.mongoexample.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User getUserById(String userId){
        User user = userRepository.findById(userId).orElse(null);
        return user;
    }

    public boolean deleteUserById(String userId){
        try {
            userRepository.deleteById(userId);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean addUser(User user){
        try {
            user.setId(UUID.randomUUID().toString());
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updateUser(String userId, User user){
        Optional<User> currentUserOptional = userRepository.findById(userId);
        if(currentUserOptional.isPresent()){
            User currentUser = currentUserOptional.get();
            currentUser.setAge(user.getAge());
            currentUser.setName(user.getName());
            currentUser.setEmail(user.getEmail());
            userRepository.save(currentUser);
            return true;
        }else {
            return false;
        }
    }

}
