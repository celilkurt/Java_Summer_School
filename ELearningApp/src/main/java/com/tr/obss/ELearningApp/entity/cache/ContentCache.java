package com.tr.obss.ELearningApp.entity.cache;


import com.tr.obss.ELearningApp.entity.Content;

public interface ContentCache {

    Content getContent(Long id);

    boolean addContent(Content content);

    Content removeContent(Content content);

    void printCacheSize();
}
