package net.moxuan.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author: moxuan
 * @description: 系统日志
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SysLog extends BaseEntity {

    private static final long serialVersionUID = 6915902058024897415L;

    private Integer logType;
    private Integer operateType;
    private String loginName;
    private String name;
    private String ip;
    private String method;
    private String requestUrl;
    private String requestParam;
    private String requestType;
    private Long elapsedTime;
    private String content;
}
