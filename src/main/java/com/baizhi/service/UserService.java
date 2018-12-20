package com.baizhi.service;

import com.baizhi.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    public String login(User user, String code, HttpSession session);

}
