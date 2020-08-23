package com.newindianews.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class CategoryDto {

    private int categoryId;

    private String categoryName;

    private List<NewsDto> news;

	public CategoryDto() {
	}

	public CategoryDto(int categoryId, String categoryName, List<NewsDto> news) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.news = news;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<NewsDto> getNews() {
		return news;
	}

	public void setNews(List<NewsDto> news) {
		this.news = news;
	}
}
