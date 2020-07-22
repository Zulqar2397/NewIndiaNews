package com.newindianews.app.service;

import java.util.List;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.entity.News;
import com.newindianews.app.exception.DatabaseException;
import com.newindianews.app.exception.ServiceException;

public interface AdminsService {

	AdminsDto registerAdmin(AdminsDto adminsDto) throws ServiceException;

	NewsDto addNews(NewsDto newsDto) throws ServiceException;

	List<News> getNewsByAdmin(String adminEmail) throws ServiceException, DatabaseException;

}
