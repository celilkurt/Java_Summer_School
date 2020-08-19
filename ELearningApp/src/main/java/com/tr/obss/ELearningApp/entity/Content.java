package com.tr.obss.ELearningApp.entity;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
public abstract class Content implements Cloneable{

    private long id;
    private String Url;
    private String name;
    private Date publishDate;
    private Date endDate;
    private long successRatio;

    public abstract void calculateSuccess();

    public Content(long id, String name, Date publishDate, Date endDate, long successRatio, String url) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
        this.endDate = endDate;
        this.successRatio = successRatio;
        this.Url = url;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", Url='" + Url + '\'' +
                ", name='" + name + '\'' +
                ", publishDate=" + publishDate +
                ", endDate=" + endDate +
                ", successRatio=" + successRatio +
                '}';
    }
}
