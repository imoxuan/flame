package net.moxuan.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author: moxuan
 * @description:
 */
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 8804497180936986868L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
