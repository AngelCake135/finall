package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner implements Serializable {

    @Id
    private Integer id;

    private String title;

    private String imgPath;

    private Date pubDate;

    private String description;

    private String status;


}