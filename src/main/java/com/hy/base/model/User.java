package com.hy.base.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wangxingli
 * @date 2018/4/14 14:52
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;

    private String userName;

    /**
     * 本人所在部门
     */
    private Long deptId;

    /**
     * 一级部门ID
     */
    private Long firstDeptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 本人所在部门的所有下级部门ID
     */
    private List<Long> subDeptIds;

    public Long getUserId() {
        return userId;
    }

    public User setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Long getDeptId() {
        return deptId;
    }

    public User setDeptId(Long deptId) {
        this.deptId = deptId;
        return this;
    }

    public List<Long> getSubDeptIds() {
        return subDeptIds;
    }

    public User setSubDeptIds(List<Long> subDeptIds) {
        this.subDeptIds = subDeptIds;
        return this;
    }
}
