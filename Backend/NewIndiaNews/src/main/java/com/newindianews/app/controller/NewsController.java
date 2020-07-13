package com.newindianews.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
