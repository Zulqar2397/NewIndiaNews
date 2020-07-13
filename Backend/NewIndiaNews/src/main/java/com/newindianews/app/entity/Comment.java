package com.newindianews.app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
@Id
@Column(name = "commentId")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int commentId;

@Column(name = "postedBy")
private String postedBy;

@Column(name = "postedDate")
private Date postedDate;

@Column(name = "comment")
private String comment;

@ManyToOne
@JoinColumn(name = "newsId", nullable = false)
private News news;

public Comment() {
	// TODO Auto-generated constructor stub
}

public Comment(int commentId, String postedBy, Date postedDate, String comment, News news) {
	super();
	this.commentId = commentId;
	this.postedBy = postedBy;
	this.postedDate = postedDate;
	this.comment = comment;
	this.news = news;
}

public int getCommentId() {
	return commentId;
}

public void setCommentId(int commentId) {
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


