//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hy.base;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用实体（通用字段）
 * Created by oukingtim
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BaseEntity<T extends BaseEntity> implements Serializable {

    @TableId(type= IdType.ID_WORKER)
    protected Long  id;

    @TableField("creator_id")
    protected Long creatorId;

    @TableField("creator_name")
    protected String creatorName;

    @TableField("create_time")
    protected Date createTime;

    @TableField("editor_id")
    protected Long editorId;

    @TableField("editor_name")
    protected String editorName;

    @TableField("edit_time")
    protected Date editTime;

    protected Serializable pkVal() {
        return id;
    }
}
