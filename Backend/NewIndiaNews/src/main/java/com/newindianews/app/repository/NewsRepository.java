package com.newindianews.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newindianews.app.entity.News;

@Repository
public interface NewsRepository extends JpaRepository<News,Integer> {

}
