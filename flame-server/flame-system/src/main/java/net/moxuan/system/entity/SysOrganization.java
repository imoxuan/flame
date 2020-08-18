package net.moxuan.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import net.moxuan.common.BaseEntity;

import javax.validation.constraints.NotBlank;

/**
 * @author: moxuan
 * @description: 集团类
 */
@TableName(value = "sys_organization", resultMap = "sysOrganization")
public class SysOrganization extends BaseEntity {

    private static final long serialVersionUID = -8166945473936393885L;

    @NotBlank(message = "机构名称为空")
    private String name;
    private String enName;
    private String shortName;

    @NotBlank(message = "机构编码为空")
    private String code;
    private Integer sortNo;

    @TableField(value = "is_enabled")
    private Boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
