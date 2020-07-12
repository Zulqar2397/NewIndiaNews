package com.newindianews.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.dto.ResponseDto;
import com.newindianews.app.exception.AppException;
import com.newindianews.app.service.AdminsService;

@RestController
@RequestMapping("/admin")

public class AdminsController {

	@Autowired
	AdminsService adminsService;
	
	@PostMapping("/registerAdmin")
	public ResponseEntity<ResponseDto<AdminsDto>> registerAdmin(@RequestBody AdminsDto adminsDto) throws AppException
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<AdminsDto>(adminsService.registerAdmin(adminsDto),null,"Assigned",true));
	}
}
