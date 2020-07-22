package com.newindianews.app.service;

import java.util.List;

import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.entity.News;
import com.newindianews.app.exception.DatabaseException;
import com.newindianews.app.exception.ServiceException;

public interface NewsService {

	List<News> getAllNews() throws ServiceException;

	News getNewsById(long newsId) throws ServiceException;

	List<News> getNewsByRegion(String region) throws ServiceException, DatabaseException;

	List<News> getNewsByCategory(String category) throws ServiceException, DatabaseException;

	List<News> getNewsByHeader(String header)throws ServiceException, DatabaseException;

	News likeNews(long newsId)throws ServiceException;


}
