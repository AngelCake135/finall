package com.baizhi.controller;


import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.CreateValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin, String code, HttpSession session){

        System.out.println(admin+"  "+code);

        String str = adminService.login(admin, code, session);

        return  str;
    }

        @RequestMapping("/image")
    public void image(OutputStream outputStream, HttpSession session)  {

            CreateValidateCode validateCode = new CreateValidateCode(100, 30);

            String code = validateCode.getCode();

        try {
            validateCode.write(outputStream);
            session.setAttribute("code",code);
        } catch (IOException e) {
            e.printStackTrace();
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }


    }

}
