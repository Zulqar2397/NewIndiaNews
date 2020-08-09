package com.newindianews.app.service;

import com.newindianews.app.dto.CommentDto;
import com.newindianews.app.dto.ImageDto;
import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.entity.Comment;
import com.newindianews.app.entity.Image;
import com.newindianews.app.exception.DatabaseException;
import com.newindianews.app.exception.ServiceException;

import java.util.List;

public interface NewsService {

//    List<News> getAllNews() throws ServiceException;
//
//    News getNewsById(long newsId) throws ServiceException;
//
//    List<News> getNewsByRegion(String region) throws ServiceException, DatabaseException;

//    List<News> getNewsByHeader(String header) throws ServiceException, DatabaseException;

    List<NewsDto> getNewsByCategory(String category) throws ServiceException, DatabaseException;

    boolean likeNews(long newsId);

    List<ImageDto> getImageDtoList(List<Image> images);

    List<CommentDto> getCommentDtoList(List<Comment> comments);

    boolean increaseHitCount(long newsId);

    CommentDto postComment(long newsId, CommentDto comment);

	NewsDto addNews(NewsDto newsDto) throws ServiceException;

	List<NewsDto> getRecentNews();

}
