package com.william.spt.entity;


import com.william.spt.core.BaseEntity;

/**
 * @author william
 */
public class User extends BaseEntity {

    private Integer userId;
    /**
     *   用户姓名
     */
    private String userName;
    /**
     *   密码
     */
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

