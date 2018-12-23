package com.baizhi.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Configuration
public class AddFile {

    @Bean
    public AddFile createFileFactory(){

        return new AddFile();
    }

    public String addFile( String realPath,MultipartFile file1) throws IOException {
        long time = new Date().getTime();



        String pathString =time+file1.getOriginalFilename();

        //创建目标文件
        File file2 = new File(realPath+"/"+pathString);


        file1.getBytes();

        file1.transferTo(file2);
        return pathString;

    }


}
