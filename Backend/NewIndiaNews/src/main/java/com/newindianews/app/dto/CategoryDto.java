package com.newindianews.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newindianews.app.entity.News;

public class CategoryDto {
	
	private int categoryId;
	
	
	private String categoryName;

//	@JsonIgnore
	private List<News> news;
	
	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(int categoryId, String categoryName, List<News> news) {
		super();
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
	
	@JsonIgnore
	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", categoryName=" + categoryName + ", news=" + news + "]";
	}
	
	
}
