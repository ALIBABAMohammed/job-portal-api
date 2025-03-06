package com.jobportal.job_portal_app.bean;

import jakarta.persistence.*;

@Entity
public class RecruiterProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userAccountId;
    @OneToOne
    @MapsId
    private Users userId;
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private String company;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String state;

    private String profilePhoto;

    public RecruiterProfile() {
    }

    public RecruiterProfile(Integer userAccountId, Users userId, String firstName, String lastName, String city, String country, String company, String profilePhoto) {
        this.userAccountId = userAccountId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
        this.company = company;
        this.profilePhoto = profilePhoto;
    }

    public RecruiterProfile(Users users) {
        this.userId = users;
    }
    public Integer getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Integer userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @Transient
    public String getPhotosImagePath() {
        if (profilePhoto == null) return null;
        return "/photos/recruiter/" + userAccountId + "/" + profilePhoto;
    }
    private String hi;

    @Override
    public String toString() {
        return "RecuiterProfile{" +
                "userAccountId=" + userAccountId +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", company='" + company + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                '}';
    }
}
