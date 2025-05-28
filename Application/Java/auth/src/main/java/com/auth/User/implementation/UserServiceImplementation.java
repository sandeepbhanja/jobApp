package com.auth.User.implementation;

import org.springframework.stereotype.Service;

import com.auth.User.User;
import com.auth.User.UserRepository;
import com.auth.User.UserService;

@Service
public class UserServiceImplementation implements UserService {

    UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean createUser(User user){
        boolean isCreated = false;
        try{
            this.userRepository.save(user);
            isCreated = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isCreated;
    }

    public boolean deleteUser(String email){
        boolean isDeleted = false;
        try{
            this.userRepository.deleteByEmail(email);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isDeleted;
    }

    public boolean updateUser(User updatedUser){
        boolean isUpdated = false;
        try{

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return isUpdated;
    }
}
