package com.qf.nwt.application.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/3 0003.
 */

public class LoginEntity implements Serializable {

    /**
     * psj : 0
     * userId : 100927
     * userToken : 5c118d640cb0d8a302ac9264d79d4fe6e
     * userName : xiaojie
     * userImgUrl : http://cdn.palshock.cn/dyimg/usr/33/100927_b51ed41e.jpg
     * gender : m
     * mobile : 18408249795
     * hasMobile : 1
     * hasPassword : 1
     * content : LOGIN OK
     * hasV : 1
     */

    private int psj;
    private int userId;
    private String userToken;
    private String userName;
    private String userImgUrl;
    private String gender;
    private String mobile;
    private int hasMobile;
    private int hasPassword;
    private String content;
    private int hasV;

    public int getPsj() {
        return psj;
    }

    public void setPsj(int psj) {
        this.psj = psj;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getHasMobile() {
        return hasMobile;
    }

    public void setHasMobile(int hasMobile) {
        this.hasMobile = hasMobile;
    }

    public int getHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(int hasPassword) {
        this.hasPassword = hasPassword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHasV() {
        return hasV;
    }

    public void setHasV(int hasV) {
        this.hasV = hasV;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "psj=" + psj +
                ", userId=" + userId +
                ", userToken='" + userToken + '\'' +
                ", userName='" + userName + '\'' +
                ", userImgUrl='" + userImgUrl + '\'' +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", hasMobile=" + hasMobile +
                ", hasPassword=" + hasPassword +
                ", content='" + content + '\'' +
                ", hasV=" + hasV +
                '}';
    }
}
