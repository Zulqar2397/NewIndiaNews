package com.newindianews.app.repository;

import com.newindianews.app.entity.Admins;
import com.newindianews.app.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, String> {
     @Query("select a from Admins a where a.email=:email")
    public Admins getNewsByAdmin(String email);

}
