package com.tr.obss.ELearningApp.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class VideoContent extends Content{

    public VideoContent(long id, String name, Date publishDate, Date endDate, long successRatio, String url) {
        super(id,name,publishDate,endDate,successRatio,url);
    }

    @Override
    public void calculateSuccess() {

    }
}
