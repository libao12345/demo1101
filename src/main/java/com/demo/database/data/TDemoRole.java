package com.demo.database.data;

import java.sql.Timestamp;

/**
 * @author Libao
 * @version 1.0.0
 * @createTime 2019年11月07日 19:20：26
 */
public class TDemoRole {

    private String roleId; //角色ID
    private String roleName; //角色名称
    private String roleDescribe; //角色描述
    private Timestamp operTime; //操作时间

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    public Timestamp getOperTime() {
        return operTime;
    }

    public void setOperTime(Timestamp operTime) {
        this.operTime = operTime;
    }
}
