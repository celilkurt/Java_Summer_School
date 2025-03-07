package com.tr.obss.ELearningApp.service.Impl;

import com.tr.obss.ELearningApp.entity.cache.ContentCache;
import com.tr.obss.ELearningApp.entity.ELearningContent;
import com.tr.obss.ELearningApp.entity.cache.InMemoryContentCache;
import com.tr.obss.ELearningApp.service.ELearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;

@Component
public class ELearningServiceImpl implements ELearningService {

    HashMap<Long,ELearningContent> contents;
    @Autowired
    ContentCache cache;

    public ELearningServiceImpl() {

        contents = new HashMap<>();
    }

    public ELearningServiceImpl(HashMap<Long, ELearningContent> contents, InMemoryContentCache cache) {
        this.contents = contents;
        this.cache = cache;
    }

    @PostConstruct
    private void postConstruct() {

        cache.printObjectType();
    }

    @Override
    public boolean createNewElearningContent(ELearningContent eLearningContent) {

        contents.put(eLearningContent.getId(),eLearningContent);
        cache.addContent(eLearningContent);
        return true;
    }

    @Override
    public ELearningContent deleteELearningContent(ELearningContent eLearningContent) {

        cache.removeContent(eLearningContent);
        return contents.remove(eLearningContent.getId());
    }

    @Override
    public String getELearningUrl(Long id) {

        return contents.get(id).getUrl();

    }

    @Override
    public ContentCache getContentCache() {

        return cache;
    }

    @PreDestroy
    private void postDestroy() {

        cache.deleteAllCache();
        contents = null;
        System.out.println("Caches and contents deleted!!");
    }
}
