package com.example.cssebackend.Service;

import com.example.cssebackend.Model.Order;
import com.example.cssebackend.Model.User;
import com.example.cssebackend.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //add users
    public void addUser(User user){
        userRepository.save(user);
    }

    //get User
    public Object getUser(String id){
        return userRepository.findById(id);
    }

    public String createUserId(){
        List<User> users = userRepository.findAll();
        String userId;

        if (users.isEmpty()){
            userId = "U" + 01;
        }
        else {
            User user = users.stream().reduce((zero, first) -> first).orElse(null);
            String lastId = user.getUserId();
            int lastIdNum = Integer.parseInt(lastId.substring(1));
            int size = lastIdNum+1;
            userId = "U" + size;
        }

        return userId;
    }
}
