package com.newindianews.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.sun.istack.NotNull;

@Entity
@Table(name = "admins")
public class Admins {

    @Id
    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "approval")
    @Value("false")
    private boolean approval;

    @OneToMany(mappedBy = "admins", cascade = CascadeType.PERSIST)
   
    private List<News> newsList;

    public Admins() {
        // TODO Auto-generated constructor stub
    }

    public Admins(String email, String firstName, String lastName, String password, boolean approval,
                  List<News> newsList) {
        
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.approval = approval;
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

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (approval ? 1231 : 1237);
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((newsList == null) ? 0 : newsList.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
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
        Admins other = (Admins) obj;
        if (approval != other.approval)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (newsList == null) {
            if (other.newsList != null)
                return false;
        } else if (!newsList.equals(other.newsList))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Admins [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
                + password + ", approval=" + approval + ", newsList=" + newsList + "]";
    }


}