package com.example.mykare.Service;

import com.example.mykare.Dto.AuthRequest;
import com.example.mykare.Entity.User;
import com.example.mykare.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public String registerUser(User user){
        try {
            var newUser=User
                    .builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .gender(user.getGender())
                    .build();
            userRepository.save(newUser);
            return "Registration success.";
        }catch (Exception e){
            System.out.println("error during register");
            System.out.println(e.getMessage());
            return "This email is already used.";
        }
    }

    public void authenticate(AuthRequest request){
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        System.out.println("in auth");

        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(SecurityContextHolder.getContext()+"hai....");
    }
    public Optional<User> findUser(String email) {
        return userRepository.findByEmail(email);
    }
}
