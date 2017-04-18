package com.ghca.ceip.web.security.util;

import javafx.scene.Parent;
import org.springframework.security.access.method.P;

import java.util.*;

/**
 * Created by gh on 2017/4/14.
 */
public class TreeUtil {


    public static <T extends TreeNode> Collection<T> merge(Collection<T> treeNodes) {
        Map<T, Collection<T>> tempMap = new HashMap<T, Collection<T>>();
        return null;

    }

/*    public static void main(String[] args) {
        SimpleTreeNode node1 = new SimpleTreeNode("1");
        SimpleTreeNode node11 = new SimpleTreeNode("11", node1);
        SimpleTreeNode node12 = new SimpleTreeNode("12", node1);
        SimpleTreeNode node13 = new SimpleTreeNode("13", node1);
        SimpleTreeNode node2 = new SimpleTreeNode("2");
        SimpleTreeNode node21 = new SimpleTreeNode("21", node2);
        SimpleTreeNode node211 = new SimpleTreeNode("211", node21);
        List
        Collection<TreeNode> merge = TreeUtil.merge(list);
        System.out.println(merge);
        Optional<List<String>> nullList = Optional.of(null);
        for(String s : nullList.get()) {
            System.out.println(s);
        }

    }*/

    public static void main(String[] args) {
        SimpleTreeNode node1 = new SimpleTreeNode("1");
        SimpleTreeNode node11 = new SimpleTreeNode("11", node1);
        SimpleTreeNode node12 = new SimpleTreeNode("12", node1);
        SimpleTreeNode node13 = new SimpleTreeNode("13", node1);
        SimpleTreeNode node2 = new SimpleTreeNode("2");
        SimpleTreeNode node21 = new SimpleTreeNode("21", node2);
        SimpleTreeNode node211 = new SimpleTreeNode("211", node21);
    }
}
