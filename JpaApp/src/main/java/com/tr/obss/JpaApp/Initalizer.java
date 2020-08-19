package com.tr.obss.JpaApp;

import com.tr.obss.JpaApp.dao.ContentRepository;
import com.tr.obss.JpaApp.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initalizer implements CommandLineRunner {

    @Autowired
    ContentRepository contentRepository;

    @Override
    public void run(String... args) throws Exception {

        Stream.of("dexter","hannibal","better call saul").forEach( name ->
                contentRepository.save(new Content(name))
        );

        contentRepository.findAll().forEach(System.out::println);

    }
}
