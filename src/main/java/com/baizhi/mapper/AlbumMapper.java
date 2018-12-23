package com.baizhi.mapper;


import com.baizhi.entity.Album;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumMapper extends Mapper<Album> {
//@Param("curPage") Integer curPage,@Param("pageSize") Integer pageSize

    public List<Album> queryAllAlbum();

}