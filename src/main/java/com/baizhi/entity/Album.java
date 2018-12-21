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
public class Album implements Serializable {

    @Id
    private Integer id;

    private String title;

    private Integer count;

    private String coverImg;

    private Integer score;

    private String aurthor;

    private String broadcast;

    private String brief;

    private Date pubDate;

    private Chapter childer;


}