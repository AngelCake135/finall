package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/slideshow")
public class BannerController {


    @RequestMapping("/query")
    public List query(){
        return null;
    }

}
