package com.newindianews.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class AdminsDto {
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private boolean approval;

    @JsonIgnoreProperties("admins")
    private List<NewsDto> newsList;

    public AdminsDto(String email, String firstName, String lastName, String password, boolean approval, List<NewsDto> newsList) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.approval = approval;
        this.newsList = newsList;
    }

    public AdminsDto() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
