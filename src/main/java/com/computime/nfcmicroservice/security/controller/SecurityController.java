package com.computime.nfcmicroservice.security.controller;

import com.computime.nfcmicroservice.security.MyUserDetailsService;
import com.computime.nfcmicroservice.security.jwtutil;
import com.computime.nfcmicroservice.security.model.AuthenticationRequest;
import com.computime.nfcmicroservice.security.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private jwtutil jwtutil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
                    );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password");
        }
        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtutil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
