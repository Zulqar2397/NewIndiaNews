package com.newindianews.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "images")
public class Image {
	@Id
	@NotNull
	@Column(name = "imageId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long imageId;
	
	@NotNull
	@Column(name = "imageUrl")
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "newsId", nullable = false)
	private News news;
	
	public Image() {
		// TODO Auto-generated constructor stub
	}

	public Image(long imageId, String imageUrl, News news) {
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

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		if (imageId != other.imageId)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
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
		return "Image [imageId=" + imageId + ", imageUrl=" + imageUrl + ", news=" + news + "]";
	}
	
	

}
