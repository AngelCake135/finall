package com.baizhi.controller;


import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import com.baizhi.util.AddFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private AddFile addFile;

    @RequestMapping("/queryAllAlbum")
    public List<Album> queryAllAlbum(Integer page, Integer rows){
        System.out.println(page+" --------- "+rows);

        List<Album> list = albumService.queryAllAlbum();

        return list;
    }

    @RequestMapping("/addAlbum")
    public void addAlbum(Album album, MultipartFile file1, HttpSession session) throws IOException {

        System.out.println("-------------------添加专辑"+album);

        ServletContext context = session.getServletContext();
        String realPath = context.getRealPath("/img/cover_img");

        String filename= addFile.addFile(realPath, file1);

        album.setCoverImg("/img/cover_img"+filename);

        albumService.addAlbum(album);
    }

    @RequestMapping("/queryOne")
    public Album queryOne(Album album){
        System.out.println("进入查询一个：");
        System.out.println(album);
        Album one = albumService.queryOne(album);

        return one;
    }

    @RequestMapping("downLoadChapter")
    public void downLoadChapter(HttpServletResponse response,Chapter ch,HttpSession session) throws IOException {
        Chapter chapter = chapterService.qyeryOne(ch);

        ServletContext ctx = session.getServletContext();

        String realPath = ctx.getRealPath("/muscic");
        String[] split = chapter.getUrl().split("/");
        for (String s : split) {
            System.out.println(s);
        }
        String chapterUrl = realPath +"\\"+split[2];
        System.out.println(chapterUrl);

        File file = new File(chapterUrl);

        // 2.获取要下载的文件名

        String fileName = split[2];

        // 3.设置content-disposition响应头控制浏览器以下载的形式打开文件
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        // 4.根据文件路径获取要下载的文件输入流
        BufferedInputStream bis = null;
        OutputStream out = null;
        try {
            bis = new BufferedInputStream(new FileInputStream((file)));
            byte[] buffer = new byte[1024];
            out = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                out.write(buffer, 0, buffer.length);
                i = bis.read(buffer);
                out.flush();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(out!=null){
                 out.close();
                }
            }
        }

    }

    @RequestMapping("/addChapter")
    public void addChapter(Chapter chapter,MultipartFile file1,HttpSession session) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, ParseException {
        ServletContext context = session.getServletContext();
        String realPath = context.getRealPath("/muscic");

        long time = new Date().getTime();
        String pathString =time+file1.getOriginalFilename();

        //创建目标文件
        File file2 = new File(realPath+"/"+pathString);

        file1.transferTo(file2);

        chapterService.addChapter(chapter);

        MP3File mp3File = (MP3File) AudioFileIO.read(file2);
        MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();

        // 单位为秒
        long time2 = audioHeader.getTrackLength();

        StringBuffer sb=new StringBuffer();

        long h=0;
        h=time2/3600;
        sb.append((h<10)?"0"+h+":":""+h+":");
        long m=0;
        m=time2%3600/60;
        sb.append((m<10)?"0"+m+":":""+m+":");
        long s=0;
        s=time2%3600%60;
        sb.append((s<10)?"0"+s:""+s);

        String toString = sb.toString();

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date parse = format.parse(toString);

        chapter.setUrl("/muscic/"+pathString);
        chapter.setDuration(parse);

        long size = file1.getSize();

        double mb=0;
            mb=size/(1024*1024*1.0);
        chapter.setSize(new Double(mb).toString().substring(0,5)+"MB");

        System.out.println("================================");
        System.out.println(chapter);

       // chapterService.addChapter(chapter);


    }
}
