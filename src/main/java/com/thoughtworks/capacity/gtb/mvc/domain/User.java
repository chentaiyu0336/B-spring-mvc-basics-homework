package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Integer id;

    @NotBlank(message = "用户名不为空")
    @Size(max = 10, min = 3, message = "用户名不合法")
    String username;

    @NotNull(message = "密码是不为空")
    @Size(max = 12, min = 5, message = "密码不合法")
    String password;

    @Email(message = "邮箱地址不合法")
    String email;
}
