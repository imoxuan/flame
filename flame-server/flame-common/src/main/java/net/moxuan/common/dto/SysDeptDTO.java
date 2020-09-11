package net.moxuan.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: moxuan
 * @description:
 */
@Data
public class SysDeptDTO implements Serializable {

    private static final long serialVersionUID = 5486329093163719885L;

    private String id;
    private String name;
    private String code;
    private Integer sortNo;
    private String path;
    private Boolean enabled;
    private Long orgId;
    private Long pid;
}
