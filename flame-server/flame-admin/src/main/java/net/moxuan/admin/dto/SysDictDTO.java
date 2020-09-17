package net.moxuan.admin.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author: moxuan
 * @description:
 */
@Data
public class SysDictDTO implements Serializable {

    private static final long serialVersionUID = 47157097799215882L;

    private String id;

    @NotBlank(message = "编码为空")
    private String code;

    @NotBlank(message = "名称为空")
    @Length(max = 30, message = "名称长度超过 {max}")
    private String name;

    private String description;

    private Boolean enabled;

}
