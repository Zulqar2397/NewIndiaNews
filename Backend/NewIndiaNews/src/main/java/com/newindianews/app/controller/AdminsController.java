package com.newindianews.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.dto.NewsDto;
import com.newindianews.app.dto.ResponseDto;
import com.newindianews.app.exception.AppException;
import com.newindianews.app.service.AdminsService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminsController {

	@Autowired
	AdminsService adminsService;
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<ResponseDto<Boolean>> registerAdmin(@RequestBody AdminsDto adminsDto) throws AppException
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<Boolean>(adminsService.registerAdmin(adminsDto),null,"Assigned",true));
	}

	@GetMapping("/login/{email}/{password}")
    ResponseEntity<ResponseDto> adminLogin(@PathVariable String email,@PathVariable String password) throws AppException
    {

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<>(adminsService.adminLogin(email,password),null,"Logged in Successfully",true));
    }

	@PostMapping("/addNews")
	public ResponseEntity<ResponseDto<NewsDto>> addNews(@RequestBody NewsDto newsDto) throws AppException
	{
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<NewsDto>(adminsService.addNews(newsDto),null,"Assigned",true));
	}
	
	@GetMapping("/getNewsByAdmin/{adminEmail}")
	public ResponseEntity<ResponseDto<List<NewsDto>>> getNewsByAdmin(@PathVariable String adminEmail ) throws AppException
	{
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<List<NewsDto>>(adminsService.getNewsByAdmin(adminEmail),null,"Retrieved Data",true));
	}
}
