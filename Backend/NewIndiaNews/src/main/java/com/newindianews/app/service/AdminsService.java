package com.newindianews.app.service;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.exception.ServiceException;

public interface AdminsService {

	AdminsDto registerAdmin(AdminsDto adminsDto) throws ServiceException;

	NewsDto addNews(NewsDto newsDto) throws ServiceException;

}
