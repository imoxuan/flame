package net.moxuan.admin.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author: moxuan
 * @description:
 */
@Data
public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = 5765969200759277383L;

    private String id;
    private String cname;
    private String loginName;
    private String userNo;
    private String password;
    private String salt;
    private String nickName;
    private Integer sortNo;
    private Boolean internal;
    private Boolean virtualized;

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
    private Boolean enabled;

}
