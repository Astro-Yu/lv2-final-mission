package finalmission.controller;

import finalmission.dto.request.LoginRequest;
import finalmission.infrastructure.jwt.JwtTokenProvider;
import finalmission.service.AuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Value("${auth.cookie.max-age}")
    private int cookieMaxAge;

    public AuthController(final AuthService authService, final JwtTokenProvider jwtTokenProvider) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(LoginRequest loginRequest) {
        // 로그인 정보를 받아서 확인하고 토큰으로 만들어서 쿠키에 넣기
        String token = authService.createToken(loginRequest);
        ResponseCookie cookie = ResponseCookie.from("token")
                .value(token)
                .httpOnly(true)
                .maxAge(cookieMaxAge)
                .path("/")
                .build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        ResponseCookie cookie = ResponseCookie.from("token")
                .httpOnly(true)
                .maxAge(0)
                .path("/")
                .build();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).build();
    }
}
