package net.moxuan.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author: moxuan
 * @description: 部门类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_department")
@ToString(callSuper = true)
public class SysDept extends BaseEntity {
    private static final long serialVersionUID = 6507964442433157086L;

    private String deptName;
    private String code;
    private Integer sortNo;

    private String path;
    @TableField(value = "parent_id")
    private Long pid;
    private Long orgId;
    @TableField(value = "is_enabled")
    private Boolean enabled;
}
