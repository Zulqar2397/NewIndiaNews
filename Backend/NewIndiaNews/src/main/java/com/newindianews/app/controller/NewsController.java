package com.newindianews.app.controller;

import com.newindianews.app.dto.CommentDto;
import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.dto.ResponseDto;
import com.newindianews.app.exception.AppException;
import com.newindianews.app.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin("*")
public class NewsController {
    @Autowired
    NewsService newsService;

    @PostMapping("/add-news")
	public ResponseEntity<ResponseDto<NewsDto>> addNews(@RequestBody NewsDto newsDto) throws AppException
	{
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<NewsDto>(newsService.addNews(newsDto),null,"Assigned",true));
	}
    
//@GetMapping("/getAllNews")
//public ResponseEntity<ResponseDto<List<News>>> getAllNews() throws AppException
//{
//	return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<List<News>>(newsService.getAllNews(),null,"Assigned",true));
//}
//
//
//
//@GetMapping("/getNewsById/{newsId}")
//public ResponseEntity<ResponseDto<News>> getNewsById(@PathVariable long newsId) throws AppException
//{
//
//	return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<News>(newsService.getNewsById(newsId),null,"Data Retrieved",true));
//
//}
//
//
//
//@GetMapping("/getNewsByRegion/{region}")
//public ResponseEntity<ResponseDto<List<News>>> getNewsByRegion(@PathVariable String region) throws AppException
//{
//
//	return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<List<News>>(newsService.getNewsByRegion(region),null,"Data Retrieved",true));
//
//}
//
//	@GetMapping("/getNewsByHeading/{header}")
//	public ResponseEntity<ResponseDto<List<News>>> getNewsByHeading(@PathVariable String header) throws AppException
//	{
//
//		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<List<News>>(newsService.getNewsByHeader(header),null,"Data Retrieved",true));
//	}


    @GetMapping("/getNewsByCategory/{category}")
    public ResponseEntity<ResponseDto<List<NewsDto>>> getNewsByCategory(@PathVariable String category) throws AppException {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<List<NewsDto>>(newsService.getNewsByCategory(category), null, "Data Retrieved", true));
    }

    //Put Mapping
    @PostMapping("/{newsId}/like")
    public ResponseEntity<ResponseDto<Boolean>> likeNews(@PathVariable long newsId) {

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<Boolean>(newsService.likeNews(newsId), null, "Assigned", true));

    }

    @PostMapping("/{newsId}/hit-count")
    public ResponseEntity<ResponseDto<Boolean>> increaseHitCount(@PathVariable long newsId) {

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<Boolean>(newsService.increaseHitCount(newsId), null, "Assigned", true));

    }


    @PostMapping("/{newsId}/post-comment")
    public ResponseEntity<ResponseDto<CommentDto>> postComment(@PathVariable long newsId, @RequestBody CommentDto comment) {

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<CommentDto>(newsService.postComment(newsId, comment), null, "Assigned", true));

    }

}
