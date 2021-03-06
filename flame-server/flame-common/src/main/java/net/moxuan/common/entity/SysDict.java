package net.moxuan.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author: moxuan
 * @description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_dict")
@ToString(callSuper = true)
public class SysDict extends BaseEntity {
    private static final long serialVersionUID = -6580174110190453519L;

    private String code;
    private String dictName;
    private String description;

    @TableField(value = "is_enabled")
    private Boolean enabled;
    private Long orgId;
}
