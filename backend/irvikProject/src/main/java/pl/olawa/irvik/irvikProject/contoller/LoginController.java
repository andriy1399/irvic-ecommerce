package pl.olawa.irvik.irvikProject.contoller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.olawa.irvik.irvikProject.dto.TokenDto;

@RestController
public class LoginController {


    @Value("${token}")
    private String token;

    @PostMapping("/login")
    public ResponseEntity getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
        if(StringUtils.isEmpty(token)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new TokenDto(token) , HttpStatus.OK);
    }


}
