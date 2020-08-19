package com.tr.obss.JpaApp.dao;

import com.tr.obss.JpaApp.entity.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContentRepository extends CrudRepository<Content, Long> {
}
