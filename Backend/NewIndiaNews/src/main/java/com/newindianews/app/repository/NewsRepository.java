package com.newindianews.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.entity.News;
import com.newindianews.app.exception.DatabaseException;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {

public List<News> findAllByAdminsEmail(String adminEmail) throws DatabaseException;
public List<News> findAllByRegion(String region) throws DatabaseException;
public List<News> findAllByCategoryCategoryName(String category)throws DatabaseException;

@Query("SELECT n FROM News n where n.title LIKE %?1% ORDER BY n.newsId DESC")
public List<News> findByHeader(String header) throws DatabaseException;
}
