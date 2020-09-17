package net.moxuan.admin.dto;

import lombok.Data;
import net.moxuan.common.vo.NodeIcon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: moxuan
 * @description:
 */

@Data
public class DeptTreeDTO implements Serializable {

    private static final long serialVersionUID = -7664179485088482141L;

    private String key;
    private String title;
    private Boolean isLeaf;
    private List<DeptTreeDTO> children;
    private String path;
    private Integer level;
    private NodeIcon slots;

    public void addChild(DeptTreeDTO childNode) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(childNode);
    }
}
