package com.baizhi.service;

import com.baizhi.dto.AlbumPageDto;
import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    public List<Album> queryAllAlbum() {


        List<Album> list = albumMapper.queryAllAlbum();

        System.out.println("-------------");
        System.out.println(list);
        System.out.println("-------------");
        return list;
    }

    @Override
    public void addAlbum(Album album) {

        albumMapper.insert(album);
    }

    @Override
    public Album queryOne(Album album) {

        Album one = albumMapper.selectOne(album);

        System.out.println("----------查询一个----------");
        System.out.println(one);

        return one;
    }
}
