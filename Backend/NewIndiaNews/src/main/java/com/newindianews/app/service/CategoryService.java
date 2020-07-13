package com.newindianews.app.service;

import com.newindianews.app.dto.CategoryDto;
import com.newindianews.app.exception.ServiceException;

public interface CategoryService {

	CategoryDto addCategory(CategoryDto categoryDto) throws ServiceException;

}
