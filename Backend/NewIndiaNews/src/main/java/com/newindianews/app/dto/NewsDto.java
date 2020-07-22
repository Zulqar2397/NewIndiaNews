package com.newindianews.app.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.newindianews.app.entity.Admins;
import com.newindianews.app.entity.Category;
import com.newindianews.app.entity.Comment;
import com.newindianews.app.entity.Image;

public class NewsDto {
	
	private long newsId;

	
	private String title;

	
	private String description;

	
	private String region;

	private String source;

	
	private long likeCount;

	private Date date;
	
	private Time time;
	
	private long hitCount;

	
	private AdminsDto admins;

   @JsonIgnoreProperties("news")
	private List<ImageDto> images;
	
   @JsonIgnoreProperties("news")
    private List<CommentDto> comments;

	
	private CategoryDto category;

	public NewsDto() {
		// TODO Auto-generated constructor stub
	}

	public NewsDto(long newsId, String title, String description, String region, String source, long likeCount,
			Date date,Time time, long hitCount, AdminsDto admins, List<ImageDto> images, List<CommentDto> comments, CategoryDto category) {
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

	public long getNewsId() {
		return newsId;
	}

	public void setNewsId(long newsId) {
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

	public long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(long likeCount) {
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

	public long getHitCount() {
		return hitCount;
	}

	public void setHitCount(long hitCount) {
		this.hitCount = hitCount;
	}

	public AdminsDto getAdmins() {
		return admins;
	}

	public void setAdmins(AdminsDto admins) {
		this.admins = admins;
	}

	
	public List<ImageDto> getImages() {
		return images;
	}

	public void setImages(List<ImageDto> images) {
		this.images = images;
	}
	
	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
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
