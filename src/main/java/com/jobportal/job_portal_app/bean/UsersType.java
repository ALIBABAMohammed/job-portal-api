package com.jobportal.job_portal_app.bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userTypeId;
    private String userTypeName;
    @OneToMany(targetEntity = Users.class, mappedBy = "userTypeId", cascade = CascadeType.ALL )
    private List<Users> users;

    public UsersType(Integer userTypeId, String userTypeName, List<Users> users) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
        this.users = users;
    }
    public UsersType() {
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
