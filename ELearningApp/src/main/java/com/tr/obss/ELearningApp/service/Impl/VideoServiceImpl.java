package com.tr.obss.ELearningApp.service.Impl;

import com.tr.obss.ELearningApp.entity.cache.ContentCache;
import com.tr.obss.ELearningApp.entity.cache.InMemoryContentCache;
import com.tr.obss.ELearningApp.entity.VideoContent;
import com.tr.obss.ELearningApp.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class VideoServiceImpl implements VideoService {

    HashMap<Long,VideoContent> contents;
    @Autowired
    @Qualifier("distributedContentCache")
    ContentCache cache;

    public VideoServiceImpl() {

        contents = new HashMap<>();
    }

    public VideoServiceImpl(HashMap<Long, VideoContent> contents, InMemoryContentCache cache) {
        this.contents = contents;
        this.cache = cache;
    }

    @Override
    public boolean createNewVideoContent(VideoContent videoContent) {

        cache.addContent(videoContent);
        return (videoContent == contents.put(videoContent.getId(),videoContent));

    }

    @Override
    public VideoContent deleteVideoContent(VideoContent videoContent) {

        cache.removeContent(videoContent);
        return contents.remove(videoContent.getId());
    }

    @Override
    public String getVideoUrl(Long id) {

        if(contents.containsKey(id))
            return contents.get(id).getUrl();
        else
            return null;
    }

    @Override
    public void updateCurrentTime(Long id, Long duration) {
        if(contents.containsKey(id))
            System.out.println("Current time: " + duration);
        else
            System.out.println("Content not found" );

    }

    @Override
    public ContentCache getContentCache() {

        return cache;
    }
}
