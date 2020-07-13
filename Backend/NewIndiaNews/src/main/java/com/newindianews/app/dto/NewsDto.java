package com.newindianews.app.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newindianews.app.entity.Admins;
import com.newindianews.app.entity.Category;
import com.newindianews.app.entity.Comment;
import com.newindianews.app.entity.Image;

public class NewsDto {
	
	private int newsId;

	
	private String title;

	
	private String description;

	
	private String region;

	private String source;

	
	private int likeCount;

	private Date date;
	
	private Time time;
	
	private int hitCount;

	
	private AdminsDto admins;

    @JsonIgnore
	private List<Image> images;
	
    @JsonIgnore
    private List<Comment> comments;

	
	private CategoryDto category;

	public NewsDto() {
		// TODO Auto-generated constructor stub
	}

	public NewsDto(int newsId, String title, String description, String region, String source, int likeCount,
			Date date,Time time, int hitCount, AdminsDto admins, List<Image> images, List<Comment> comments, CategoryDto category) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.description = description;
		this.region = region;
		this.source = source;
		this.likeCount = likeCount;
		this.date = date;
		this.time = time;
		this.hitCount = hitCount;
		this.admins = admins;
		this.images = images;
		this.comments = comments;
		this.category = category;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public AdminsDto getAdmins() {
		return admins;
	}

	public void setAdmins(AdminsDto admins) {
		this.admins = admins;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "NewsDto [newsId=" + newsId + ", title=" + title + ", description=" + description + ", region=" + region
				+ ", source=" + source + ", likeCount=" + likeCount + ", date=" + date + ", time=" + time
				+ ", hitCount=" + hitCount + ", admins=" + admins + ", images=" + images + ", comments=" + comments
				+ ", category=" + category + "]";
	}

	

}
