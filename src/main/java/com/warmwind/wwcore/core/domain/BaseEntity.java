package com.warmwind.wwcore.core.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author warmwind
 * @createTime 2024-02-28 23:38
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 创建人 **/
    private String createBy;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新人 */
    private String updateBy;

    /** 更新时间 */
    private LocalDateTime updateTime;

    public BaseEntity() {
    }

    public BaseEntity(String createBy, LocalDateTime createTime, String updateBy, LocalDateTime updateTime) {
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
