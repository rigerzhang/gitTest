package com.xunjia.pojo;

public class User {
    private Integer id;
    private String usr;
    private String pwd;
    private String email;

    public User() {
    }

    public User(Integer id, String usr, String pwd, String email) {
        this.id = id;
        this.usr = usr;
        this.pwd = pwd;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsr() {
        return usr;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usr='" + usr + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
