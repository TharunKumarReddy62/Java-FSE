package com.cognizant.springLearn3.controller;

import com.cognizant.springLearn3.dto.JwtResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);
    private static final String SECRET =
            "mysecretkeymysecretkeymysecretkey12";

    @GetMapping("/authenticatee")
    public JwtResponse authenticate() {

        return new JwtResponse("Dummy JWT Token");
    }


    @GetMapping("/authenticate")
    public Map<String, String> authenticate(
            @RequestHeader("Authorization") String authHeader) {

        LOGGER.info("START");
        //LOGGER.debug("Authorization Header : {}", authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("User: {}", user);

        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        LOGGER.info("END");
        return map;
    }

    private String getUser(String authHeader) {

        LOGGER.debug("Decoding Authorization Header");

        String encodedCredentials = authHeader.substring("Basic ".length());

        LOGGER.debug("Encoded Credentials: {}", encodedCredentials);

        byte[] decodedBytes =
                Base64.getDecoder().decode(encodedCredentials);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        LOGGER.debug("Decoded Credentials: {}", credentials);

        String user = credentials.substring(0, credentials.indexOf(":"));

        LOGGER.debug("Username: {}", user);

        return user;
    }


    private String generateJwt(String user) {

        LOGGER.debug("Generating JWT");

        SecretKey key = Keys.hmacShaKeyFor(
                SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(user)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
                .signWith(key)
                .compact();
    }
}