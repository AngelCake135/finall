package com.baizhi.controller;


import com.baizhi.entity.Menu;
import com.baizhi.mapper.MenuMapper;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;


    @RequestMapping("/queryAllMenu")
    public List<Menu> queryAllMenu(){

        List<Menu> list = menuService.queryAllMenu();

        return list;

    }



}
