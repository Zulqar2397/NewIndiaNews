package com.newindianews.app.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
@Id
@Column(name = "commentId")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long commentId;

@Column(name = "postedBy")
private String postedBy;

@Column(name = "postedDate")
private Date postedDate;

@Column(name = "comment")
private String comment;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "newsId",nullable = true)
private News news;

public Comment() {
	// TODO Auto-generated constructor stub
}

public Comment(long commentId, String postedBy, Date postedDate, String comment, News news) {
	super();
	this.commentId = commentId;
	this.postedBy = postedBy;
	this.postedDate = postedDate;
	this.comment = comment;
	this.news = news;
}

public long getCommentId() {
	return commentId;
}

public void setCommentId(long commentId) {
	this.commentId = commentId;
}

public String getPostedBy() {
	return postedBy;
}

public void setPostedBy(String postedBy) {
	this.postedBy = postedBy;
}

public Date getPostedDate() {
	return postedDate;
}

public void setPostedDate(Date postedDate) {
	this.postedDate = postedDate;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public News getNews() {
	return news;
}

public void setNews(News news) {
	this.news = news;
}

@Override
public String toString() {
	return "Comment [commentId=" + commentId + ", postedBy=" + postedBy + ", postedDate=" + postedDate + ", comment="
			+ comment + ", news=" + news + "]";
}

}

