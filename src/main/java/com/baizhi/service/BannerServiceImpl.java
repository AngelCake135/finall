package com.baizhi.service;

import com.baizhi.dto.BannerPageDto;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public BannerPageDto queryAllBanner(Integer page,Integer rows) {

        System.out.println(page+"  "+rows);
       List<Banner> list = bannerMapper.selectByRowBounds(new Banner(),new RowBounds((page-1)*rows,rows*page));

      /*  Example example = new Example(Banner.class);
        example.setOrderByClause("id desc");
        List<Banner> list1 = bannerMapper.selectByExample(example);*/


        BannerPageDto dto = new BannerPageDto(bannerMapper.selectCount(new Banner()), list);

        System.out.println(list);

        return dto;
    }

    @Override
    public void updateBanner(Banner banner) {

        System.out.println(banner+"  adaad");
        int i = bannerMapper.updateByPrimaryKey(banner);
        System.out.println("==== "+i);

    }

    @Override
    public void deleteBanner(Banner banner) {
        bannerMapper.delete(banner);
        System.out.println("--------------------");
        System.out.println(banner);
    }

    @Override
    public void addBanner(Banner banner) {

        bannerMapper.insert(banner);
        System.out.println(banner);

    }

    @Override
    public void saveStatus(Banner banner) {

        System.out.println(banner+" -- ");
        bannerMapper.updateByPrimaryKeySelective(banner);


    }
}
