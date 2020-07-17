package com.newindianews.app.service;

import java.util.List;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.exception.DatabaseException;
import com.newindianews.app.exception.ServiceException;

public interface AdminsService {

	boolean registerAdmin(AdminsDto adminsDto) throws ServiceException;

	NewsDto addNews(NewsDto newsDto) throws ServiceException;

	List<NewsDto> getNewsByAdmin(String adminEmail) throws ServiceException, DatabaseException;

	String passwordEncryptor(String password);

	boolean adminLogin(String email,String password) throws ServiceException;

}
