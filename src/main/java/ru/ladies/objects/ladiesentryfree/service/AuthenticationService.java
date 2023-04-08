package ru.ladies.objects.ladiesentryfree.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ladies.objects.ladiesentryfree.model.dto.AuthRequestDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.AuthenticationResponseDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.RegisterRequestDTO;
import ru.ladies.objects.ladiesentryfree.model.entities.userRelated.User;
import ru.ladies.objects.ladiesentryfree.repository.UserRepository;
import ru.ladies.objects.ladiesentryfree.service.security.JwtService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;


    public AuthenticationResponseDTO register(RegisterRequestDTO registerDTO) {
        User user = User.builder()
                .firstname(registerDTO.getFirstname())
                .lastname(registerDTO.getLastname())
                .email(registerDTO.getEmail())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .build();

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseDTO authenticate(AuthRequestDTO authDTO) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authDTO.getLogin(),
                        authDTO.getPassword()
                )
        );

        User user = userRepository.findByEmail(authDTO.getLogin())
                .orElseThrow();

        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}