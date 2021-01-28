package pl.olawa.irvik.irvikProject.contoller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.olawa.irvik.irvikProject.config.JwtUtil;
import pl.olawa.irvik.irvikProject.domain.Token;
import pl.olawa.irvik.irvikProject.dto.AuthRequesr;

@RestController
public class LoginController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     *
     */

    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }


    @PostMapping("/login")
    public Token generareToken(@RequestBody AuthRequesr authRequesr) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequesr.getUserName(), authRequesr.getPassword())
            );
        } catch (Exception exception) {
            throw new Exception("inavalid userna/passwrd");
        }

            return new Token(jwtUtil.generateToken(authRequesr.getUserName()));

        }

    }

