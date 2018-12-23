package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {

    public List<Album> queryAllAlbum();

    public void addAlbum(Album album);

    public Album queryOne(Album album);


}
