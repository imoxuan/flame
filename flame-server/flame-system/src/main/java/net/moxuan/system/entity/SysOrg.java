package net.moxuan.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.moxuan.common.BaseEntity;

/**
 * @author: moxuan
 * @description: 机构类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_organization")
public class SysOrg extends BaseEntity {

    private static final long serialVersionUID = -8166945473936393885L;

    private String name;
    private String enName;
    private String shortName;
    private String code;
    private Integer sortNo;

    @TableField(value = "is_enabled")
    private Boolean enabled;

}
