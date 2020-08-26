package net.moxuan.system.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: moxuan
 * @description:
 */
@Data
public class SysOrgDTO implements Serializable {

    private static final long serialVersionUID = -8770232461326766594L;

    private String id;
    private String name;
    private String enName;
    private String shortName;
    private String code;
    private Integer sortNo;
    private Boolean enabled;

}
