package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class AdminServiceImpl implements  AdminService{

    @Autowired
    AdminMapper adminMapper;



    @Override
    public String login(Admin admin, String code, HttpSession session) {

        String  code1 =(String) session.getAttribute("code");

        if(!code.toLowerCase().equals(code1)) return "验证码错误";
        Admin admin1 = new Admin();
        admin1.setPhone(admin.getPhone());
        Admin admin2 = adminMapper.selectOne(admin1);
        if(admin2==null) return "用户不存在";

        if(!admin2.getPassword().equals(admin.getPassword())) return "密码错误";

        session.setAttribute("phone",admin.getPhone());
        return "ok";
    }
}
