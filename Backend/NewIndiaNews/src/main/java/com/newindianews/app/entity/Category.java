package com.newindianews.app.entity;

import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@NotNull
	@Column(name = "categoryId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@NotNull
	@Column(name = "categoryName")
	private String categoryName;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<News> news;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryId, String categoryName, List<News> news) {
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

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((news == null) ? 0 : news.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (news == null) {
			if (other.news != null)
				return false;
		} else if (!news.equals(other.news))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", news=" + news + "]";
	}
	
	


}
