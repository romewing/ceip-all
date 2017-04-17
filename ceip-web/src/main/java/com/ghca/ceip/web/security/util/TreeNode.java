package com.ghca.ceip.web.security.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by gh on 2017/4/14.
 */
public interface TreeNode<T> extends Serializable{

    T getParent();

    Collection<T> getChildren();

    default  boolean isLeaf() {
        return getChildren()==null || getChildren().isEmpty();
    }

    default boolean isRoot() {
        return getParent()==null;
    }

    void setChildren(Collection<T> children);

    void setParent(T parent);


}
