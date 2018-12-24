package com.baizhi.service;

import com.baizhi.entity.Chapter;
import com.baizhi.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.lang.reflect.Field;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

   @Autowired
   private ChapterMapper chapterMapper;

    @Override
    public Chapter qyeryOne(Chapter chapter) {

        Chapter one = chapterMapper.selectOne(chapter);

        return one;
    }

    @Override
    public void addChapter(Chapter chapter) {
        String uuid = UUID.randomUUID().toString();
        chapter.setId(uuid);
        chapterMapper.insert(chapter);

    }

    @Override
    public void deleteChapter(Chapter chapter) {

        Chapter one = chapterMapper.selectOne(chapter);


        chapterMapper.deleteByPrimaryKey(chapter);
        File file = new File(one.getUrl());
        file.delete();


    }
}
