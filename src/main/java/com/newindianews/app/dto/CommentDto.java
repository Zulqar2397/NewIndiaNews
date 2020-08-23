package com.newindianews.app.dto;

import java.sql.Date;

public class CommentDto {
	private long commentId;

	private String postedBy;

	private Date postedDate;

	private String comment;

	private NewsDto news;
public CommentDto() {
	// TODO Auto-generated constructor stub
}
public CommentDto(long commentId, String postedBy, Date postedDate, String comment, NewsDto news) {
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
public NewsDto getNews() {
	return news;
}
public void setNews(NewsDto news) {
	this.news = news;
}
@Override
public String toString() {
	return "CommentDto [commentId=" + commentId + ", postedBy=" + postedBy + ", postedDate=" + postedDate + ", comment="
			+ comment + ", news=" + news + "]";
}

}
