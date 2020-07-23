package com.newindianews.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.newindianews.app.entity.News;

public class AdminsDto {
    private String email;

    private String firstName;

    private String lastName;

    private boolean approval;

    @JsonIgnoreProperties("admins")
    private List<NewsDto> newsList;

    public AdminsDto() {
        // TODO Auto-generated constructor stub
    }

    public AdminsDto(String email, String firstName, String lastName,
                     List<NewsDto> newsList) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.newsList = newsList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public List<NewsDto> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsDto> newsList) {
        this.newsList = newsList;
    }


}
