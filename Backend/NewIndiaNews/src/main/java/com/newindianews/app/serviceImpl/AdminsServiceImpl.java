package com.newindianews.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.entity.Admins;
import com.newindianews.app.entity.News;
import com.newindianews.app.exception.AdminAlreadyExistsException;
import com.newindianews.app.exception.NewsAlreadyExistsException;
import com.newindianews.app.exception.ServiceException;
import com.newindianews.app.repository.AdminsRepository;
import com.newindianews.app.repository.NewsRepository;
import com.newindianews.app.service.AdminsService;

@Service
public class AdminsServiceImpl implements AdminsService{
	
	@Autowired
	AdminsRepository adminsRepo;
	@Autowired
	NewsRepository newsRepo;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public AdminsDto registerAdmin(AdminsDto adminsDto) throws ServiceException {
		// TODO Auto-generated method stub
		Admins admins = convertAdminsDtoToEntity(adminsDto);
		if(adminsRepo.existsById(adminsDto.getEmail()))
		{
			throw new AdminAlreadyExistsException("Admin Already Exists!!");
		}

		return convertAdminsEntityToDto(adminsRepo.save(admins));
	}
	
	@Override
	public NewsDto addNews(NewsDto newsDto) throws ServiceException {
		// TODO Auto-generated method stub
		News news = convertNewsDtoToEntity(newsDto);
		if(newsRepo.existsById(newsDto.getNewsId()))
		{
			throw new NewsAlreadyExistsException("News Already Exists!!");
		}
		return convertNewsEntityToDto(newsRepo.save(news));
	}
	
	
	
	
	
	
	
	
	
	
	
	private AdminsDto convertAdminsEntityToDto(Admins admins)
	{
		return modelMapper.map(admins, AdminsDto.class);
	}
	
	private Admins convertAdminsDtoToEntity(AdminsDto adminsDto)
	{
		return modelMapper.map(adminsDto, Admins.class);
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
