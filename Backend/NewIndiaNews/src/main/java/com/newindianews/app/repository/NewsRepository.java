package com.newindianews.app.repository;

import com.newindianews.app.entity.News;
import com.newindianews.app.exception.DatabaseException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    public List<News> findAllByAdminsEmail(String adminEmail) throws DatabaseException;

    public List<News> findAllByRegion(String region) throws DatabaseException;

    public List<News> findAllByCategoryCategoryName(String category) throws DatabaseException;

    @Query("SELECT n FROM News n where n.title LIKE %?1% ORDER BY n.newsId DESC")
    public List<News> findByHeader(String header) throws DatabaseException;

    @Query(value = "Select * from news ORDER BY news_id DESC LIMIT 5", nativeQuery = true)
    public List<News> getRecentNews();

    @Query(value = "Select * from news where category_id=1 ORDER BY hit_count DESC LIMIT 4", nativeQuery = true)
    public List<News> getPopularPoliticsNews();

    @Query(value = "Select * from news where category_id=2 ORDER BY hit_count DESC LIMIT 4", nativeQuery = true)
    public List<News> getPopularBusinessAndEconomyNews();

    @Query(value = "Select * from news where category_id=3 ORDER BY hit_count DESC LIMIT 4", nativeQuery = true)
    public List<News> getPopularWorldNews();

    @Query(value = "Select * from news where category_id=4 ORDER BY hit_count DESC LIMIT 4", nativeQuery = true)
    public List<News> getPopularTechnologyNews();

    @Query(value = "Select * from news ORDER BY like_count DESC LIMIT 5", nativeQuery = true)
    public List<News> getMostLikedNews();
}
