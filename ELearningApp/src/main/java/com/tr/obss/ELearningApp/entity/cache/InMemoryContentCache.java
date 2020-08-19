package com.tr.obss.ELearningApp.entity.cache;

import com.tr.obss.ELearningApp.entity.Content;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("inMemoryContentCache")
@Scope("prototype")
public class InMemoryContentCache implements ContentCache {

    HashMap<Long, Content> contents;

    public InMemoryContentCache() {
        contents = new HashMap<>();
    }



    public InMemoryContentCache(HashMap<Long, Content> contents) {
        this.contents = contents;
    }

    @Override
    public Content getContent(Long id) {

        return contents.get(id);
    }

    @Override
    public boolean addContent(Content content) {

        return content == contents.put(content.getId(),content);

    }

    @Override
    public Content removeContent(Content content) {

        return contents.remove(content.getId());
    }

    @Override
    public void printCacheSize() {
        System.out.println("Cache size: " + contents.size());
    }
}
