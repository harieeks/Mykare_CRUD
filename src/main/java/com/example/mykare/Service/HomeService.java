package com.example.mykare.Service;

import com.example.mykare.Entity.User;
import com.example.mykare.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final UserRepository userRepository;
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @Transactional
    public String deleteUser(String email){
        try {
            userRepository.deleteByEmail(email);
            return "Success fully deleted";
        }catch (Exception e){
            System.out.println(e.getMessage()+"failed to delete");
            return "Failed to delete user";
        }
    }
}
