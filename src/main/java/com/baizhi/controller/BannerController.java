package com.baizhi.controller;

import com.baizhi.dto.BannerPageDto;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import com.baizhi.util.AddFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;


@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private AddFile addFile;

    @RequestMapping("/queryAllBanner")
    public BannerPageDto queryAllBanner(Integer page, Integer rows){

        BannerPageDto dto = bannerService.queryAllBanner(page, rows);

        return dto;
    }

    @RequestMapping("/updateBanner")
    public void updateBanner(Banner banner){

    }

    @RequestMapping("/deleteBanner")
    public void deleteBanner(Banner banner){
        bannerService.deleteBanner(banner);

    }

    @RequestMapping("/addBanner")
    public void addBanner(Banner banner, MultipartFile file1, HttpSession session) throws IOException {

        ServletContext context = session.getServletContext();
        String realPath = context.getRealPath("/img/shouye");

        String pathString = addFile.addFile(realPath, file1);
        banner.setImgPath("/img/shouye/"+pathString);
      /*  long time = new Date().getTime();
        String pathString=time+file1.getOriginalFilename();
        //创建目标文件
        File file2 = new File(realPath+"/"+pathString);

        file1.transferTo(file2);
        System.out.println("-----------------------");
        System.out.println(realPath);
        System.out.println(pathString);

*/
        bannerService.addBanner(banner);


    }

    @RequestMapping("/saveStatus")
    public void saveStatus(Banner banner){

        bannerService.saveStatus(banner);
    }


}
