package com.example.mykare.Controller;

import com.example.mykare.Entity.User;
import com.example.mykare.Service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(homeService.getAllUser());
    }

    @DeleteMapping("/delete-user")
    public String deleteUser(@RequestBody Map<String,String> emailMap){
        String email=emailMap.get("email");
        return homeService.deleteUser(email);
    }
}
