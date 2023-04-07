package ru.ladies.objects.ladiesentryfree.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ladies.objects.ladiesentryfree.model.dto.AuthRequestDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.AuthenticationResponseDTO;
import ru.ladies.objects.ladiesentryfree.model.dto.RegisterRequestDTO;
import ru.ladies.objects.ladiesentryfree.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestDTO registerDTO
    ) {
        return ResponseEntity.ok().body(authService.register(registerDTO));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody AuthRequestDTO authRequestDTO
    ) {
        return ResponseEntity.ok().body(authService.authenticate(authRequestDTO));
    }
}
