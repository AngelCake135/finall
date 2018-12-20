package com.baizhi.controller;


import com.baizhi.entity.User;
import com.baizhi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    public String login(User user){



        return null;
    }

    /*public void image(OutputStream outputStream, HttpSession session)  {

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


    }*/


}
