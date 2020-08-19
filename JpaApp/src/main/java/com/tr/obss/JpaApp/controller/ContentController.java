package com.tr.obss.JpaApp.controller;


import com.tr.obss.JpaApp.dao.ContentRepository;
import com.tr.obss.JpaApp.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/content/")
public class ContentController {

    @Autowired
    ContentRepository contentRepository;

    @GetMapping
    public @ResponseBody List<Content> getContents(){

        return (List<Content>) contentRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Optional<Content> addContent(@RequestBody Content content){

        contentRepository.save(content);
        return  contentRepository.findById(content.getId());
    }

}
