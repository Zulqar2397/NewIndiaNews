package com.newindianews.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.entity.Admins;
import com.newindianews.app.entity.Category;
import com.newindianews.app.entity.Comment;
import com.newindianews.app.entity.Image;
import com.newindianews.app.entity.News;
import com.newindianews.app.exception.AdminAlreadyExistsException;
import com.newindianews.app.exception.DatabaseException;
import com.newindianews.app.exception.NewsAlreadyExistsException;
import com.newindianews.app.exception.ServiceException;
import com.newindianews.app.repository.AdminsRepository;
import com.newindianews.app.repository.CategoryRepository;
import com.newindianews.app.repository.NewsRepository;
import com.newindianews.app.service.AdminsService;

@Service
public class AdminsServiceImpl implements AdminsService{
	
	@Autowired
	AdminsRepository adminsRepo;
	@Autowired
	NewsRepository newsRepo;
	@Autowired
	AdminsRepository adminRepo;
	@Autowired
	CategoryRepository categoryRepo;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	
	//The Model Conversion methods
	
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
		
//		Admins admin = adminRepo.findById(news.getAdmins().getEmail()).get();
//	    List<News> newsListAdmin= admin.getNewsList();
//	    newsListAdmin.add(news);
//	    admin.setNewsList(newsListAdmin);
//	    adminRepo.save(admin);
//	    
//	    
//	    Category category = categoryRepo.findById((long) news.getCategory().getCategoryId()).get();
//	   System.out.println("=============="+category.getCategoryName());
//	    List<News> newsListCategory = category.getNews();
//	    newsListCategory.add(news);
//	    category.setNews(newsListCategory);
//	    categoryRepo.save(category);
	    
	    if(news.getImages()!=null) {
		List<Image> images = news.getImages();
		for (Image image : images) {
			image.setNews(news);
			//images.add(image);
		}
		//news.setImages(images);
	    }
	    if(news.getComments()!=null) {
		List<Comment> comments = news.getComments();
		for (Comment comment : comments) {
			comment.setNews(news);
		//	comments.add(comment);
		}
	//	news.setComments(comments);
	    }
		if(newsRepo.existsById(newsDto.getNewsId()))
		{
			throw new NewsAlreadyExistsException("News Already Exists!!");
		}
		return convertNewsEntityToDto(newsRepo.save(news));
	}
	
	
	
	@Override
	public List<NewsDto> getNewsByAdmin(String adminEmail) throws ServiceException, DatabaseException {
		// TODO Auto-generated method stub
		List<NewsDto> newsDtoList = new ArrayList<NewsDto>();
		
		//try {
			List<News> newsList= newsRepo.findAllByAdminsEmail(adminEmail);
			for (News news : newsList) {
				NewsDto newsDto = convertNewsEntityToDto(news);
				newsDtoList.add(newsDto);
			
			}
//		} catch (DatabaseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return newsDtoList;
	}













	
	
}
