package com.authservice.service;

import com.authservice.DTO.ErrorResponseDTO;
import com.authservice.DTO.ResponseDTO;
import com.authservice.DTO.UserDto;
import com.authservice.entity.User;
import com.authservice.records.UserRequest;
import com.authservice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<ResponseDTO> createUser(UserRequest request) {

        if (userRepository.findByUsername(request.username()).isPresent()) {
            ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
            errorResponseDTO.setMessage("User Already Exist");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseDTO);
        }

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(request.role());
        user.setEnabled(true);

        User savedUser = userRepository.save(user);

        UserDto response = new UserDto(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getRole(),
                savedUser.isEnabled()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
