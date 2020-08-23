package com.newindianews.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newindianews.app.dto.CategoryDto;
import com.newindianews.app.entity.Category;
import com.newindianews.app.exception.ServiceException;
import com.newindianews.app.repository.CategoryRepository;
import com.newindianews.app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepo;
	private ModelMapper modelMapper = new ModelMapper();


	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) throws ServiceException {
		// TODO Auto-generated method stub
		Category category = convertCategoryDtoToEntity(categoryDto);
		
		return convertCategoryEntityToDto(categoryRepo.save(category));
	}
	private CategoryDto convertCategoryEntityToDto(Category category)
	{
		return modelMapper.map(category, CategoryDto.class);
	}
	
	private Category convertCategoryDtoToEntity(CategoryDto categoryDto)
	{
		return modelMapper.map(categoryDto, Category.class);
	}
	@Override
	public List<CategoryDto> getAllCategories() throws ServiceException {
		
		
		List<CategoryDto> categoryList = new ArrayList<CategoryDto>();
		categoryRepo.findAll().forEach(item->{
			categoryList.add(new CategoryDto(item.getCategoryId(),item.getCategoryName(),null));
		});
		return categoryList;
	}
}
