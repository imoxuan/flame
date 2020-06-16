package net.moxuan.system.entity;

import net.moxuan.common.BaseEntity;

/**
 * @author: moxuan
 * @description: 集团类
 */
public class SysOrganization extends BaseEntity {

    private static final long serialVersionUID = -8166945473936393885L;

    private String name;
    private String enName;
    private String shortName;
    private String code;
    private int sortNo;
    private Boolean enable;

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

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

}
