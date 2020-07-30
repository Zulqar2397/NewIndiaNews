package com.newindianews.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.dto.CategoryDto;
import com.newindianews.app.dto.ResponseDto;
import com.newindianews.app.exception.AppException;
import com.newindianews.app.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@PostMapping("/addCategory")
	public ResponseEntity<ResponseDto<CategoryDto>> addCategory(@RequestBody CategoryDto categoryDto) throws AppException
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<CategoryDto>(categoryService.addCategory(categoryDto),null,"Assigned",true));
	}
	
	@GetMapping("/getAllCategories")
	public ResponseEntity<ResponseDto<List<CategoryDto>>> getAllCategories() throws AppException
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<List<CategoryDto>>(categoryService.getAllCategories(),null,"Retrieved",true));
	}

}
