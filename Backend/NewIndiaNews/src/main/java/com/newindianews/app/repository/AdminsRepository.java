package com.newindianews.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newindianews.app.entity.Admins;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, String> {


}
