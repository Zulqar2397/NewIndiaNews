package com.newindianews.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.dto.ResponseDto;
import com.newindianews.app.exception.AppException;
import com.newindianews.app.repository.NewsRepository;
import com.newindianews.app.service.NewsService;

@RestController
@RequestMapping("/news")
public class NewsController {
@Autowired
NewsService newsService;



@GetMapping("/getAllNews")
public ResponseEntity<ResponseDto<List<NewsDto>>> getAllNews() throws AppException
{
	return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<List<NewsDto>>(newsService.getAllNews(),null,"Assigned",true));
}



@GetMapping("/getNewsById/{newsId}")
public ResponseEntity<ResponseDto<NewsDto>> getNewsById(@PathVariable long newsId) throws AppException
{

	return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<NewsDto>(newsService.getNewsById(newsId),null,"Data Retrieved",true));	

}



@GetMapping("/getNewsByRegion/{region}")
public ResponseEntity<ResponseDto<List<NewsDto>>> getNewsByRegion(@PathVariable String region) throws AppException
{

	return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<List<NewsDto>>(newsService.getNewsByRegion(region),null,"Data Retrieved",true));

}



@GetMapping("/getNewsByCategory/{category}")
public ResponseEntity<ResponseDto<List<NewsDto>>> getNewsByCategory(@PathVariable String category) throws AppException
{

	return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<List<NewsDto>>(newsService.getNewsByCategory(category),null,"Data Retrieved",true));

}



@GetMapping("/getNewsByHeading/{header}")
public ResponseEntity<ResponseDto<List<NewsDto>>> getNewsByHeading(@PathVariable String header) throws AppException
{

	return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<List<NewsDto>>(newsService.getNewsByHeader(header),null,"Data Retrieved",true));
}


//Put Mapping
@PostMapping("/{newsId}/like")
public ResponseEntity<ResponseDto<NewsDto>> likeNews(@PathVariable long newsId) throws AppException
{

	return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<NewsDto>(newsService.likeNews(newsId),null,"Assigned",true));
	
}





}
