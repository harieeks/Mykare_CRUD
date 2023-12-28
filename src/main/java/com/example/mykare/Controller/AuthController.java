package com.example.mykare.Controller;

import com.example.mykare.Dto.AuthRequest;
import com.example.mykare.Entity.User;
import com.example.mykare.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        System.out.println("haii");
        var result=service.registerUser(user);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest request){
        System.out.println("hello");
        service.authenticate(request);
        return ResponseEntity.ok().body("login success");
    }

    @GetMapping("/hi")
    public String getHai(Authentication authentication){

        return "hai";
    }
}
