package com.newindianews.app.serviceImpl;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.dto.CategoryDto;
import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.entity.Admins;
import com.newindianews.app.entity.News;
import com.newindianews.app.exception.*;
import com.newindianews.app.repository.AdminsRepository;
import com.newindianews.app.repository.CategoryRepository;
import com.newindianews.app.repository.NewsRepository;
import com.newindianews.app.service.AdminsService;
import com.newindianews.app.service.NewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminsServiceImpl implements AdminsService {

    @Autowired
    AdminsRepository adminsRepo;
    @Autowired
    NewsRepository newsRepo;
    @Autowired
    AdminsRepository adminRepo;
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    NewsService newsService;

    private ModelMapper modelMapper = new ModelMapper();


    //The Model Conversion methods

    private AdminsDto convertAdminsEntityToDto(Admins admins) {
        return modelMapper.map(admins, AdminsDto.class);
    }

    private Admins convertAdminsDtoToEntity(AdminsDto adminsDto) {
        return modelMapper.map(adminsDto, Admins.class);
    }

    private NewsDto convertNewsEntityToDto(News news) {
        return modelMapper.map(news, NewsDto.class);
    }

    private News convertNewsDtoToEntity(NewsDto newsDto) {
        return modelMapper.map(newsDto, News.class);
    }


    @Override
    public boolean registerAdmin(AdminsDto adminsDto) throws ServiceException {
        // TODO Auto-generated method stub
        Admins admins = convertAdminsDtoToEntity(adminsDto);
        if (adminsRepo.existsById(adminsDto.getEmail())) {
            throw new AdminAlreadyExistsException("Admin Already Exists!!");
        }
        admins.setApproval(false);
        admins.setPassword(this.passwordEncryptor(admins.getPassword()));
        adminsRepo.save(admins);
        return true;
    }


//	@Override
//	public NewsDto addNews(NewsDto newsDto) throws ServiceException {
//		// TODO Auto-generated method stub
//		News news = convertNewsDtoToEntity(newsDto);
//
//
//
//		if (news.getImages() != null) {
//			List<Image> images = news.getImages();
//			for (Image image : images) {
//				image.setNews(news);
//				//images.add(image);
//			}
//			//news.setImages(images);
//		}
//		if (news.getComments() != null) {
//			List<Comment> comments = news.getComments();
//			for (Comment comment : comments) {
//				comment.setNews(news);
//				//	comments.add(comment);
//			}
//			//	news.setComments(comments);
//		}
//		if (newsRepo.existsById(newsDto.getNewsId())) {
//			throw new NewsAlreadyExistsException("News Already Exists!!");
//		}
//		return convertNewsEntityToDto(newsRepo.save(news));
//	}


    @Override
    public List<NewsDto> getNewsByAdmin(String adminEmail) throws ServiceException, DatabaseException {
        List<News> news = adminsRepo.getNewsByAdmin(adminEmail).getNewsList();
        List<NewsDto> newsList = new ArrayList<NewsDto>();
        news.parallelStream().map(item -> newsList.add(
                new NewsDto(item.getNewsId(), item.getTitle(), item.getDescription(), item.getRegion(), item.getSource(),
                        item.getLikeCount(), item.getDate(), item.getTime(), item.getHitCount(), new AdminsDto(item.getAdmins().getEmail(),
                        item.getAdmins().getFirstName(), item.getAdmins().getLastName(), null, false, null), newsService.getImageDtoList(item.getImages()),
                        newsService.getCommentDtoList(item.getComments()), new CategoryDto(item.getCategory().getCategoryId(), item.getCategory()
                        .getCategoryName(), null)
                ))
        ).collect(Collectors.toList());
        return newsList;
    }

    @Override
    public String passwordEncryptor(String password) {
        try {
            MessageDigest message = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = message.digest(password.getBytes());
            BigInteger num = new BigInteger(1, messageDigest);
            String hashText = num.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public boolean adminLogin(String email, String password) throws ServiceException {
        boolean isLoggedIn = false;
        String encryptedPassword = this.passwordEncryptor(password);
        if (adminsRepo.existsById(email)) {
            if (adminsRepo.getOne(email).getPassword().equals(encryptedPassword)) {
                isLoggedIn = true;
            } else {
                throw new InvalidPasswordException("Password is Invalid! ");
            }
        } else {
            throw new InvalidEmailException("Email is invalid : " + email);
        }
        return isLoggedIn;
    }

    @Override
    public AdminsDto getAdminDetailByMailId(String adminEmail) throws ServiceException {
        // TODO Auto-generated method stub
        Admins admin = adminRepo.findById(adminEmail).get();
        AdminsDto adminsDto = new AdminsDto();
        adminsDto.setEmail(admin.getEmail());
        adminsDto.setFirstName(admin.getFirstName());
        adminsDto.setLastName(admin.getLastName());
        adminsDto.setPassword(admin.getPassword());
        adminsDto.setApproval(admin.isApproval());
//		List<News> newsList = admin.getNewsList();
//		List<NewsDto> newsDtos = new ArrayList<NewsDto>();
//		for (News news : newsList) {
//			NewsDto newsDto = convertNewsEntityToDto(news);
//			newsDtos.add(newsDto);
//		}
//		adminsDto.setNewsList(newsDtos);
        return adminsDto;
        //return convertAdminsEntityToDto(admin);

    }

}