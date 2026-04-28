package com.projecthub.auth.contoller;


import com.projecthub.auth.dto.LoginDto;
import com.projecthub.auth.dto.LoginResponceDto;
import com.projecthub.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("auth/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    @PostMapping
    public LoginResponceDto login(@RequestBody LoginDto loginDto){
        System.out.println(loginDto.getEmail()+" "+loginDto.getPassword());
        return loginService.login(loginDto);
    }
}
