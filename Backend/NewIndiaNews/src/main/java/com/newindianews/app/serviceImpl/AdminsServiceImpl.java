package com.newindianews.app.serviceImpl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.newindianews.app.exception.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.entity.Admins;
import com.newindianews.app.entity.News;
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
	public boolean registerAdmin(AdminsDto adminsDto) throws ServiceException {
		// TODO Auto-generated method stub
		Admins admins = convertAdminsDtoToEntity(adminsDto);
		if(adminsRepo.existsById(adminsDto.getEmail()))
		{
			throw new AdminAlreadyExistsException("Admin Already Exists!!");
		}
        admins.setApproval(false);
		admins.setPassword(this.passwordEncryptor(admins.getPassword()));
		adminsRepo.save(admins);
		return true;
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

	@Override
	public String passwordEncryptor(String password) {
		try{
			MessageDigest message = MessageDigest.getInstance("SHA-1");
			byte[] messageDigest = message.digest(password.getBytes());
			BigInteger num = new BigInteger(1,messageDigest);
			String hashText = num.toString(16);
			while( hashText.length()<32){
				hashText= "0"+hashText;
			}
			return hashText;
		}
		catch(NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean adminLogin(String email, String password) throws ServiceException{
		boolean isLoggedIn = false;
		String encryptedPassword = this.passwordEncryptor(password);
        if(adminsRepo.existsById(email))
		{
         if(adminsRepo.getOne(email).getPassword().equals(encryptedPassword))
		 {
		 	isLoggedIn=true;
		 }
         else{
         	throw new InvalidPasswordException("Password is Invalid! ");
		 }
		}
        else
		{
			throw new InvalidEmailException("Email is invalid : "+email);
		}
		return isLoggedIn;
	}


}
