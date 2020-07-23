package com.newindianews.app.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.newindianews.app.dto.*;
import com.newindianews.app.entity.Comment;
import com.newindianews.app.entity.Image;
import com.newindianews.app.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newindianews.app.entity.News;
import com.newindianews.app.exception.DatabaseException;
import com.newindianews.app.exception.ServiceException;
import com.newindianews.app.repository.NewsRepository;
import com.newindianews.app.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepo;

    @Autowired
    CommentRepository commentRepository;
    private ModelMapper modelMapper = new ModelMapper();


    private NewsDto convertNewsEntityToDto(News news) {
        return modelMapper.map(news, NewsDto.class);
    }

    private News convertNewsDtoToEntity(NewsDto newsDto) {
        return modelMapper.map(newsDto, News.class);
    }


//
//	@Override
//	public News getNewsById(long newsId) throws ServiceException {
//
//		// TODO Auto-generated method stub
//		//NewsDto newsDto = convertNewsEntityToDto(newsRepo.findById(newsId).get());
//		News newsDto = newsRepo.findById(newsId).get();
//		long hitCount;
//		hitCount = newsDto.getHitCount();
//		hitCount = hitCount + 1;
//		newsDto.setHitCount(hitCount);
//
//	//	return convertNewsEntityToDto(newsRepo.save(convertNewsDtoToEntity(newsDto)));
//		return newsDto;
//	//	return convertNewsEntityToDto(newsRepo.findById(newsId).get());
//	}


//	@Override
//	public List<News> getAllNews() throws ServiceException {
//		// TODO Auto-generated method stub
//		List<News> newsList = newsRepo.findAll();
////		List<NewsDto> newsDtoList = new ArrayList<NewsDto>();
////		for (News news : newsList) {
////
////			NewsDto newsDto = convertNewsEntityToDto(news);
////			newsDtoList.add(newsDto);
////
////		}
////		return newsDtoList;
//		return newsList;
//	}

//	@Override
//	public List<News> getNewsByRegion(String region) throws ServiceException, DatabaseException {
//		// TODO Auto-generated method stub
//		List<NewsDto> newsDtoList= new ArrayList<NewsDto>();
//		List<News> newsList = newsRepo.findAllByRegion(region);
////		for (News news : newsList) {
////			NewsDto newsDto = convertNewsEntityToDto(news);
////			newsDtoList.add(newsDto);
////		}
////		return newsDtoList;
//		return newsList;
//	}


//	@Override
//	public List<News> getNewsByHeader(String header) throws ServiceException, DatabaseException {
//		// TODO Auto-generated method stub
//		List<NewsDto> newsDtoList= new ArrayList<NewsDto>();
//		List<News> newsList = newsRepo.findByHeader(header);
////		for (News news : newsList) {
////			NewsDto newsDto = convertNewsEntityToDto(news);
////			newsDtoList.add(newsDto);
////		}
////
////
////		return newsDtoList;
//		return newsList;
//	}


    @Override
    public List<NewsDto> getNewsByCategory(String category) throws ServiceException, DatabaseException {
        List<NewsDto> newsList = new ArrayList<NewsDto>();


        newsRepo.findAllByCategoryCategoryName(category).parallelStream().map(item -> newsList.add(
                new NewsDto(item.getNewsId(), item.getTitle(), item.getDescription(), item.getRegion(), item.getSource(),
                        item.getLikeCount(), item.getDate(), item.getTime(), item.getHitCount(), new AdminsDto(item.getAdmins().getEmail(),
                        item.getAdmins().getFirstName(), item.getAdmins().getLastName(), null), this.getImageDtoList(item.getImages()),
                        this.getCommentDtoList(item.getComments()), new CategoryDto(item.getCategory().getCategoryId(), item.getCategory()
                        .getCategoryName(), null)
                ))
        ).collect(Collectors.toList());

        return newsList;
    }


    @Override
    public boolean likeNews(long newsId) {
        News news = newsRepo.findById(newsId).get();
        news.setLikeCount(news.getLikeCount() + 1);
        newsRepo.saveAndFlush(news);
        return true;
    }

    @Override
    public List<ImageDto> getImageDtoList(List<Image> images) {
        List<ImageDto> imagesDto = new ArrayList<ImageDto>();
        images.stream().map(
                img -> imagesDto.add(new ImageDto(img.getImageId(), img.getImageUrl(), null))).collect(Collectors.toList());
        return imagesDto;
    }

    @Override
    public List<CommentDto> getCommentDtoList(List<Comment> comments) {
        List<CommentDto> commentsDto = new ArrayList<CommentDto>();
        comments.stream().map(
                com -> commentsDto.add(new CommentDto(com.getCommentId(), com.getPostedBy(), com.getPostedDate(), com.getComment(), null))).collect(Collectors.toList());
        return commentsDto;
    }

    @Override
    public boolean increaseHitCount(long newsId) {
        News news = newsRepo.getOne(newsId);
        news.setHitCount(news.getHitCount() + 1);
        newsRepo.saveAndFlush(news);
        return true;
    }

    @Override
    public CommentDto postComment(long newsId, CommentDto commentDto) {
        List<CommentDto> comments = new ArrayList<CommentDto>();
        News news = newsRepo.getOne(newsId);
        Comment comment = new Comment();
        comment.setPostedBy(commentDto.getPostedBy());
        comment.setComment(commentDto.getComment());
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        comment.setPostedDate(date);
        comment.setNews(news);
        Comment savedComment = commentRepository.save(comment);
        CommentDto savedCommentDto = new CommentDto();
        BeanUtils.copyProperties(savedComment, savedCommentDto);
        return savedCommentDto;
    }


}
