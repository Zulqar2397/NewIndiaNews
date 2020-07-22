package com.newindianews.app.dto;

public class ImageDto {
	private long imageId;

	private String imageUrl;

	private NewsDto news;
	
	public ImageDto() {
		// TODO Auto-generated constructor stub
	}

	public ImageDto(long imageId, String imageUrl, NewsDto news) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
		this.news = news;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public NewsDto getNews() {
		return news;
	}

	public void setNews(NewsDto news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "ImageDto [imageId=" + imageId + ", imageUrl=" + imageUrl + ", news=" + news + "]";
	}
	

}

