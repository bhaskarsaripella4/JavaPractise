package com.protean.flakey.dto;


import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Boolean active;
    private String password;
    private String roles;
    private String userName;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public Boolean getActive() {
        return active;
    }
    public String getRoles(){
        return roles;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", active='" + active + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
