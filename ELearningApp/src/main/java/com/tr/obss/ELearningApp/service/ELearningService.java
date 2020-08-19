package com.tr.obss.ELearningApp.service;

import com.tr.obss.ELearningApp.entity.cache.ContentCache;
import com.tr.obss.ELearningApp.entity.ELearningContent;

public interface ELearningService {

    boolean createNewElearningContent(ELearningContent eLearningContent);

    ELearningContent deleteELearningContent(ELearningContent eLearningContent);

    String getELearningUrl(Long id);

    ContentCache getContentCache();

}
