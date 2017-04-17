package com.ghca.ceip.web.security.util;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by gh on 2017/4/14.
 */
public class SimpleTreeNode implements TreeNode<SimpleTreeNode>{

    private SimpleTreeNode parent;

    private Collection<SimpleTreeNode> children = new HashSet<>();

    private String name;

    public SimpleTreeNode(String name, SimpleTreeNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public SimpleTreeNode(String name) {
        this(name, null);
    }

    @Override
    public SimpleTreeNode getParent() {
        return parent;
    }

    @Override
    public Collection<SimpleTreeNode> getChildren() {
        return children;
    }

    @Override
    public void setChildren(Collection<SimpleTreeNode> children) {
        this.children = children;
    }

    @Override
    public void setParent(SimpleTreeNode parent) {

        this.parent = parent;
    }


}
