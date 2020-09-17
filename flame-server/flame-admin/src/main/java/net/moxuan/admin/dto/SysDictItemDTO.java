package net.moxuan.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author: moxuan
 * @description:
 */
@Data
public class SysDictItemDTO implements Serializable {

    private static final long serialVersionUID = 6087883522538255530L;

    private String id;

    private String dictId;

    @NotBlank(message = "编码为空")
    private String dictCode;

    private String itemKey;
    private String itemValue;

    private Integer sortNo;

    private String description;

    private Boolean enabled;

}
