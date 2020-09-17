package net.moxuan.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: moxuan
 * @description:
 */
@Data
@TableName(value = "sys_dict_item")
@ToString(callSuper = true)
public class SysDictItem implements Serializable {

    private static final long serialVersionUID = 3143030593115234494L;

    @TableId
    private Long id;
    private Long dictId;
    private String dictCode;
    private String itemKey;
    private String itemValue;
    private Integer sortNo;
    private String description;

    @TableField(value = "is_enabled")
    private Boolean enabled;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;
}
