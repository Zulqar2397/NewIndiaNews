package com.newindianews.app.entity;

import java.sql.Date;
import java.sql.Time;
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

	@Column(name = "date")
	private Date date;
	
	@Column(name="time")
	private Time time;
	
	@Column(name = "hitCount")
	@Value("0")
	private int hitCount;

	@ManyToOne
	@JoinColumn(name = "adminEmail", nullable = false)
	private Admins admins;

	@OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
	private List<Image> images;
	
	@OneToMany(mappedBy = "news",cascade = CascadeType.ALL)
	private List<Comment> comments;

	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = false)
	private Category category;


	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(int newsId, String title, String description, String region, String source, int likeCount,
			Date date,Time time, int hitCount, Admins admins, List<Image> images, List<Comment> comments, Category category) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.description = description;
		this.region = region;
		this.source = source;
		this.likeCount = likeCount;
		this.date = date;
		this.time= time;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", title=" + title + ", description=" + description + ", region=" + region
				+ ", source=" + source + ", likeCount=" + likeCount + ", date=" + date + ", time=" + time
				+ ", hitCount=" + hitCount + ", admins=" + admins + ", images=" + images + ", comments=" + comments
				+ ", category=" + category + "]";
	}

	
	
	

}