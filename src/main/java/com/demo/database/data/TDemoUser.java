package com.demo.database.data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户表的持久化类
 * @author Teacher
 * @version 1.0.0
 * @createTime 2019年10月12日 15:21:53
 */
public class TDemoUser implements Serializable {

    private Integer userId; //用户ID
    private String userName; //用户名
    private String userPassword; //密码
    private String userGender; //性别
    private Timestamp operTime; //操作时间
    private TDemoRole tdemoRole; //角色

    public TDemoRole getTdemoRole() {
        return tdemoRole;
    }

    public void setTdemoRole(TDemoRole tdemoRole) {
        this.tdemoRole = tdemoRole;
    }

    public String getPrimaryKey() {
        return "userId";
    }

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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Timestamp getOperTime() {
        return operTime;
    }

    public void setOperTime(Timestamp operTime) {
        this.operTime = operTime;
    }
}
