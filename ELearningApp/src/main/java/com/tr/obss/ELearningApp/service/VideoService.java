package com.tr.obss.ELearningApp.service;

import com.tr.obss.ELearningApp.entity.cache.ContentCache;
import com.tr.obss.ELearningApp.entity.VideoContent;

public interface VideoService {

    boolean createNewVideoContent(VideoContent videoContent);

    VideoContent deleteVideoContent(VideoContent videoContent);

    String getVideoUrl(Long id);

    void updateCurrentTime(Long id, Long duration);

    ContentCache getContentCache();




}
