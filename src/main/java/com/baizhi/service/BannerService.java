package com.baizhi.service;

import com.baizhi.dto.BannerPageDto;
import com.baizhi.entity.Banner;


public interface BannerService {

    public BannerPageDto queryAllBanner(Integer page, Integer rows);

    public void updateBanner(Banner banner);

    public void deleteBanner(Banner banner);


    public void addBanner(Banner banner);

    public void saveStatus(Banner banner);

}
