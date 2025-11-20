package com.codewithmosh.store.auth;

import com.codewithmosh.store.users.UserDto;
import com.codewithmosh.store.users.UserMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserMapper userMapper;
    private final JwtConfig jwtConfig;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletResponse response) {

        var loginResponse = authService.login(request);
        response.addCookie(createRefreshTokenCookie(loginResponse.getRefreshToken()));
        return ResponseEntity.ok(new JwtResponse(loginResponse.getAccessToken().toString()));
    }

    @PostMapping("/refresh")
   public ResponseEntity<JwtResponse> refresh(
           @CookieValue(value = "refreshToken") String refreshToken
    ){
        var accessToken = authService.refreshAccessToken(refreshToken);
        return ResponseEntity.ok(new JwtResponse(accessToken.toString()));
   }

    @GetMapping("/me")
    public ResponseEntity<UserDto> me(){
        var user = authService.getCurrentUser();
        if (user == null) {
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    private Cookie createRefreshTokenCookie(Jwt refreshToken) {
        var cookie = new Cookie("refreshToken", refreshToken.toString());
        cookie.setHttpOnly(true); // not accessible to javascript
        cookie.setPath("/auth/refresh"); // where the cookie can be sent to
        cookie.setMaxAge(jwtConfig.getRefreshTokenExpiration());
        cookie.setSecure(true); // Only sent over https connections
        return cookie;
    }
}
