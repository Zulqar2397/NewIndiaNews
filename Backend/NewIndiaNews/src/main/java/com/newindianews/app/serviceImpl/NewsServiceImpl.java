package com.newindianews.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.entity.News;
import com.newindianews.app.exception.DatabaseException;
import com.newindianews.app.exception.ServiceException;
import com.newindianews.app.repository.NewsRepository;
import com.newindianews.app.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService {
@Autowired
NewsRepository newsRepo;
	private ModelMapper modelMapper = new ModelMapper();

	
	
	
	private NewsDto convertNewsEntityToDto(News news)
	{
		return modelMapper.map(news, NewsDto.class);
	}
	
	private News convertNewsDtoToEntity(NewsDto newsDto)
	{
		return modelMapper.map(newsDto, News.class);
	}



	@Override
	public NewsDto getNewsById(long newsId) throws ServiceException {
		// TODO Auto-generated method stub
		return convertNewsEntityToDto(newsRepo.findById(newsId).get());
	}
	@Override
	public List<NewsDto> getAllNews() throws ServiceException {
		// TODO Auto-generated method stub
		List<News> newsList = newsRepo.findAll();
		List<NewsDto> newsDtoList = new ArrayList<NewsDto>();
		for (News news : newsList) {
			
			NewsDto newsDto = convertNewsEntityToDto(news);
			newsDtoList.add(newsDto);
			
		}
		return newsDtoList;
	}

	@Override
	public List<NewsDto> getNewsByRegion(String region) throws ServiceException, DatabaseException {
		// TODO Auto-generated method stub
		List<NewsDto> newsDtoList= new ArrayList<NewsDto>();
		List<News> newsList = newsRepo.findAllByRegion(region);
		for (News news : newsList) {
			NewsDto newsDto = convertNewsEntityToDto(news);
			newsDtoList.add(newsDto);
		}
		return newsDtoList;
	}
	
	
	
	@Override
	public List<NewsDto> getNewsByCategory(String category) throws ServiceException, DatabaseException {
		// TODO Auto-generated method stub
		List<NewsDto> newsDtoList= new ArrayList<NewsDto>();
		List<News> newsList = newsRepo.findAllByCategoryCategoryName(category);
		for (News news : newsList) {
			NewsDto newsDto = convertNewsEntityToDto(news);
			newsDtoList.add(newsDto);
		}
		return newsDtoList;
	}
	
	
}
