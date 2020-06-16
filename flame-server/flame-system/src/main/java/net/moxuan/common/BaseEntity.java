package net.moxuan.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: moxuan
 * @description: 通用 entity
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 229976649864186420L;

    private Long id;
    private Boolean deleted;
    private Date gmtCreate;
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
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
