package com.newindianews.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newindianews.app.dto.AdminsDto;
import com.newindianews.app.entity.Admins;
import com.newindianews.app.exception.AdminAlreadyExistsException;
import com.newindianews.app.exception.ServiceException;
import com.newindianews.app.repository.AdminsRepository;
import com.newindianews.app.service.AdminsService;

@Service
public class AdminsServiceImpl implements AdminsService{
	
	@Autowired
	AdminsRepository adminsRepo;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public AdminsDto registerAdmin(AdminsDto adminsDto) throws ServiceException {
		// TODO Auto-generated method stub
		Admins admins = convertAdminsDtoToEntity(adminsDto);
		if(adminsRepo.existsById(adminsDto.getEmail()))
		{
			throw new AdminAlreadyExistsException("Admin Already Exists!!");
		}

		return convertAdminsEntityToDto(adminsRepo.save(admins));
	}
	
	private AdminsDto convertAdminsEntityToDto(Admins admins)
	{
		return modelMapper.map(admins, AdminsDto.class);
	}
	
	private Admins convertAdminsDtoToEntity(AdminsDto adminsDto)
	{
		return modelMapper.map(adminsDto, Admins.class);
	}

	
	
}
