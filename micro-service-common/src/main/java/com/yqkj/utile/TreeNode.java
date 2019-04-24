package com.yqkj.utile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @date 2017年11月9日23:33:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode implements Serializable {

    protected int id;

    protected int parentId;

    protected List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node) {
        children.add(node);
    }
}
