package net.moxuan.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @author: moxuan
 * @description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
@ToString(callSuper = true)
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 4587527792475919256L;

    private String name;
    private String loginName;
    private String userNo;
    private String password;
    private String salt;
    private String nickName;
    private Integer sortNo;
    
    @TableField(value = "is_internal")
    private Boolean internal;

    @TableField(value = "is_virtual")
    private Boolean virtualized;

    @TableField(value = "is_admin")
    private Boolean admin;

    private Integer gender;
    private Integer state;
    private LocalDate birthday;
    private Integer accountState;
    private LocalDate workStartDate;
    private Integer userType;
    private String insideTel;
    private String outsideTel;
    private String office;
    private String mobile;
    private String email;
    private Long orgId;
    @TableField(value = "is_enabled")
    private Boolean enabled;

}
