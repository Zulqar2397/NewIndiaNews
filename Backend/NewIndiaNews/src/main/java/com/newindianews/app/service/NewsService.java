package com.newindianews.app.service;

import java.util.List;

import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.exception.DatabaseException;
import com.newindianews.app.exception.ServiceException;

public interface NewsService {

	List<NewsDto> getAllNews() throws ServiceException;

	NewsDto getNewsById(long newsId) throws ServiceException;

	List<NewsDto> getNewsByRegion(String region) throws ServiceException, DatabaseException;

	List<NewsDto> getNewsByCategory(String category) throws ServiceException, DatabaseException;


}
