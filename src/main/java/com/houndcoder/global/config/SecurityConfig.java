package com.houndcoder.global.config;

import com.houndcoder.auth.jwt.JwtFilter;
import com.houndcoder.auth.jwt.JwtUtil;
import com.houndcoder.auth.jwt.LoginFilter;
import com.houndcoder.members.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final MemberRepository memberRepository;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtUtil jwtUtil;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 허용된 경로
        List<String> permitAllPaths = List.of(
                "/api/v1/",
                "/api/v1/signup",
                "/api/v1/login",
                "/api/v1/check/email",
                "/oauth/**"
        );

        // security 기본 설정
        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer ->
                        httpSecurityCorsConfigurer.configurationSource(corsFilter()));
        // authentication 관련 설정
        http.authorizeHttpRequests((request) -> request
                .requestMatchers(permitAllPaths.toArray(new String[0])).permitAll()
                .requestMatchers(
                        "/api/v1/members/me/**",
                        "/api/v1/calendars/**",
                        "/api/v1/daily/**"
                ).authenticated()
                .anyRequest().permitAll()
        );
        http
                .addFilterBefore(new JwtFilter(jwtUtil, memberRepository, permitAllPaths), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new LoginFilter(authenticationManager(authenticationConfiguration), jwtUtil), UsernamePasswordAuthenticationFilter.class);
        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    // CORS 설정
    @Bean
    public CorsConfigurationSource corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // cors 설정
        config.setAllowedOriginPatterns(List.of("http://127.0.0.1:3000", "http://localhost:3000"));
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);
        config.setExposedHeaders(List.of("Authorization"));
        // source -> config 적용
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
