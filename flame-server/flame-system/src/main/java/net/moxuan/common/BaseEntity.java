package net.moxuan.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: moxuan
 * @description: 通用 entity
 */
public abstract class BaseEntity extends AbstractEntity {

    private static final long serialVersionUID = 229976649864186420L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField(value = "is_deleted")
    private Boolean deleted;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getGmtCreate() {
        return (Date) gmtCreate.clone();
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = (Date) gmtCreate.clone();
    }

    public Date getGmtModified() {
        return (Date) gmtModified.clone();
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = (Date) gmtModified.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
