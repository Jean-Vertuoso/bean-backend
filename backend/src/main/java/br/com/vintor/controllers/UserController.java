package br.com.vintor.controllers;

import br.com.vintor.business.dto.in.LoginDtoRequest;
import br.com.vintor.business.dto.in.UserDtoRequest;
import br.com.vintor.business.dto.out.LoginDtoResponse;
import br.com.vintor.business.dto.out.UserDtoResponse;
import br.com.vintor.business.services.UserService;
import br.com.vintor.infrastructure.security.CookieUtil;
import br.com.vintor.infrastructure.security.JwtUtil;
import br.com.vintor.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
@Tag(name = "Users", description = "Registration and management of users")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil, CookieUtil cookieUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.cookieUtil = cookieUtil;
    }

    @PostMapping("/login")
    @Operation(summary = "User Login", description = "Authenticate a user using email and password")
    @ApiResponse(responseCode = "200", description = "User successfully logged in")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    @ApiResponse(responseCode = "500", description = "Server error")
    public LoginDtoResponse login(@RequestBody LoginDtoRequest loginDto, HttpServletResponse response){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),
                        loginDto.getPassword())
        );

        String jwt = jwtUtil.generateToken(authentication.getName());
        cookieUtil.addJwtToCookie(response, jwt);

        return new LoginDtoResponse("Bearer "+ jwt, loginDto.getEmail());
    }

    @GetMapping("/check")
    public ResponseEntity<Void> authCheck(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    @Operation(summary = "Create User", description = "Creates a new user")
    @ApiResponse(responseCode = "200", description = "User successfully saved")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    @ApiResponse(responseCode = "409", description = "User already registered")
    @ApiResponse(responseCode = "500", description = "Server error")
    public ResponseEntity<UserDtoResponse> saveUser(@RequestBody UserDtoRequest userDto){
        UserDtoResponse userDtoResponse = userService.saveUser(userDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDtoResponse.getId())
                .toUri();

        return ResponseEntity.created(uri).body(userDtoResponse);
    }
}
