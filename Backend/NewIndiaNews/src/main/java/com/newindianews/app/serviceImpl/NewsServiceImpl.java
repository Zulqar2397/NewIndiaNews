package com.newindianews.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.entity.News;
import com.newindianews.app.exception.ServiceException;
import com.newindianews.app.repository.NewsRepository;
import com.newindianews.app.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService {
@Autowired
NewsRepository newsRepo;
	private ModelMapper modelMapper = new ModelMapper();

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
	
	
	
	private NewsDto convertNewsEntityToDto(News news)
	{
		return modelMapper.map(news, NewsDto.class);
	}
	
	private News convertNewsDtoToEntity(NewsDto newsDto)
	{
		return modelMapper.map(newsDto, News.class);
	}
}
