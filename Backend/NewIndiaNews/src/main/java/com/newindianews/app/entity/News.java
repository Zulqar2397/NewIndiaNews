package com.newindianews.app.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.sun.istack.NotNull;

@Entity
@Table(name = "news")
public class News {
	@Id
	@NotNull
	@Column(name = "newsId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int newsId;

	@NotNull
	@Column(name = "title")
	private String title;

	@NotNull
	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "region")
	private String region;

	@Column(name = "source")
	private String source;

	@Column(name = "likeCount")
	@Value("0")
	private int likeCount;

	@Column(name = "dateTime")
	private Date dateTime;

	@ManyToOne
	@JoinColumn(name = "adminEmail", nullable = false)
	private Admins admins;

	@OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
	private List<Image> images;

	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = false)
	private Category category;

	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(int newsId, String title, String description, String region, String source, int likeCount,
			Date dateTime, Admins admins, List<Image> images, Category category) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.description = description;
		this.region = region;
		this.source = source;
		this.likeCount = likeCount;
		this.dateTime = dateTime;
		this.admins = admins;
		this.images = images;
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Admins getAdmins() {
		return admins;
	}

	public void setAdmins(Admins admins) {
		this.admins = admins;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admins == null) ? 0 : admins.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + likeCount;
		result = prime * result + newsId;
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		News other = (News) obj;
		if (admins == null) {
			if (other.admins != null)
				return false;
		} else if (!admins.equals(other.admins))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (likeCount != other.likeCount)
			return false;
		if (newsId != other.newsId)
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", title=" + title + ", description=" + description + ", region=" + region
				+ ", source=" + source + ", likeCount=" + likeCount + ", dateTime=" + dateTime + ", admins=" + admins
				+ ", images=" + images + ", category=" + category + "]";
	}

}
