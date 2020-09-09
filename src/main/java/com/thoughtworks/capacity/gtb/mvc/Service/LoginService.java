package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExitException;
import com.thoughtworks.capacity.gtb.mvc.exception.WrongLoginMessageException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginService {

    List<User> userList = new ArrayList<>();

    public LoginService() {
        userList.add(new User(1, "XiaoMin", "x1234", "12@3.com"));
        userList.add(new User(2, "DaBing", "d23456", "82@1.com"));
    }

    public void registerUser(User user) {
        userList.stream().forEach((currentUser) -> {
            if (user.getUsername().equals(currentUser.getUsername()))
                throw new UserExitException("用户已存在");
        });
        user.setId(userList.size() + 1);
        userList.add(user);
    }

    public User login(String username, String password) {
        List<User> userChosen = userList.stream()
                .filter(currentUser -> currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password))
                .collect(Collectors.toList());
        if (userChosen.size() == 0) {
            throw new WrongLoginMessageException("用户名或密码错误");
        }
        return userChosen.get(0);
    }

}
