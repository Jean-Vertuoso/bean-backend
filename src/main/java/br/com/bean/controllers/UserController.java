package br.com.bean.controllers;

import br.com.bean.business.dto.LoginRequestDto;
import br.com.bean.business.dto.LoginResponseDto;
import br.com.bean.business.dto.UserDto;
import br.com.bean.business.dto.UserLoggedDto;
import br.com.bean.business.services.UserService;
import br.com.bean.infrastructure.security.CookieUtil;
import br.com.bean.infrastructure.security.JwtUtil;
import br.com.bean.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Registration and management of users")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class UserController {

    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;

    public UserController(UserService service, AuthenticationManager authenticationManager, JwtUtil jwtUtil, CookieUtil cookieUtil) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.cookieUtil = cookieUtil;
    }

    @GetMapping(value = "/me")
    public ResponseEntity<UserLoggedDto> getMe(){
        return ResponseEntity.ok(service.getMe());
    }

    @PostMapping("/login")
    @Operation(summary = "User Login", description = "Authenticate a user using email and password")
    @ApiResponse(responseCode = "200", description = "User successfully logged in")
    @ApiResponse(responseCode = "401", description = "Invalid credentials")
    @ApiResponse(responseCode = "500", description = "Server error")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginDto, HttpServletResponse response){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );

        String jwt = jwtUtil.generateToken(authentication.getName());
        cookieUtil.addJwtToCookie(response, jwt);

        return new LoginResponseDto(
                "Bearer "+ jwt,
                loginDto.getEmail()
        );
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie.from("jwt", "")
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(0)
                .sameSite("None")
                .build();

        response.addHeader("Set-Cookie", cookie.toString());

        return ResponseEntity.noContent().build();
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
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto dtoRequest){
        UserDto dtoResponse = service.saveUser(dtoRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dtoResponse.getId())
                .toUri();

        return ResponseEntity.created(uri).body(dtoResponse);
    }
}
