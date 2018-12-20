package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String login(User user, String code, HttpSession session) {

    User user1 = new User();
        user1.setPhone(user.getPhone());
    User user2 = userMapper.selectOne(user1);
        if(!code.toLowerCase().equals(session.getAttribute("code"))){
        return "验证码错误";
    }
        if(user2==null) return "用户不存在";
        if(!user.getPassword().equals(user2.getPassword()))
            return "密码错误";
        return "ok";
}
}
