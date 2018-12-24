package com.baizhi.service;

import com.baizhi.entity.Chapter;

public interface ChapterService {

    public Chapter qyeryOne(Chapter chapter);

    public void addChapter(Chapter chapter);
    public void deleteChapter(Chapter chapter);

}
