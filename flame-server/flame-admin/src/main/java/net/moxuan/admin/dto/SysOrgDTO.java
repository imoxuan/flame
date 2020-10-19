package net.moxuan.admin.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * @author: moxuan
 * @description:
 */
@Data
public class SysOrgDTO implements Serializable {
    // TODO 每个字段长度都必须校验

    private static final long serialVersionUID = -8770232461326766594L;

    private String id;

    @NotBlank(message = "机构名称为空")
    @Length(max = 30, message = "机构名称长度超过 {max}")
    private String orgName;

    private String enName;
    private String shortName;

    @NotBlank(message = "编码为空")
    private String code;

    @Positive(message = "排序值必须是大于 0 的整数")
    private Integer sortNo;
    private Boolean enabled;

}
