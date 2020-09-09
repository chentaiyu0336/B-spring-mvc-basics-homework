package com.thoughtworks.capacity.gtb.mvc.Controller;

import com.thoughtworks.capacity.gtb.mvc.Service.LoginService;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@Validated
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Valid User user) {
        loginService.registerUser(user);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/login")
    public User login(@RequestParam @NotBlank(message = "用户名不为空") @Size(max = 10, min = 3, message = "用户名不合法") @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message = "用户名不合法，只能由字母、数字或下划线组成") String username,
                      @RequestParam @NotNull(message = "密码是不为空") @Size(max = 12, min = 5, message = "密码不合法") String password) {
        User user = loginService.login(username, password);
        return user;
    }

}
