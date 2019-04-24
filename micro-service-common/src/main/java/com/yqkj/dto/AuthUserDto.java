package com.yqkj.dto;

import java.io.Serializable;

/**
 *
  * class_name: AuthUserDto
  * describe: do
  * @author: yangchao.cool@gmail.com
  * creat_date: 上午12:29
  *
 **/
public class AuthUserDto implements Serializable {

    private Long id;
    private String address;
    private String avatar;
    private String description;
    private String email;
    private String mobile;
    private String nickName;
    private String password;
    private Integer sex;
    private Integer status;
    private Integer type;
    private String username;
    private Long departmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getDepartmentId() {
        return null == departmentId? 0: departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "AuthUserDto{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", status=" + status +
                ", type=" + type +
                ", username='" + username + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
