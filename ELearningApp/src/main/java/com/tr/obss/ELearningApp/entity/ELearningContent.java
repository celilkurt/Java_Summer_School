package com.tr.obss.ELearningApp.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ELearningContent extends Content{

    public ELearningContent(long id, String name, Date publishDate, Date endDate, long successRatio, String url) {
        super(id,name,publishDate,endDate,successRatio,url);
    }

    @Override
    public void calculateSuccess() {
        System.out.println("Success!");
    }


}
