package com.ghca.ceip.web.security.util;

import javafx.scene.Parent;
import org.springframework.security.access.method.P;

import java.util.*;

/**
 * Created by gh on 2017/4/14.
 */
public class TreeUtil {


    public static <T extends TreeNode> Collection<T> merge(Collection<T> treeNodes) {
        Collection<T> trees = new HashSet<>();
        for (T treeNode : treeNodes) {
            if (treeNode.getParent()==null) {
                trees.add(treeNode);
            }
            for (T it : treeNodes) {
                if (treeNode.equals(it.getParent())) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new HashSet());
                    }
                    treeNode.getChildren().add(it);
                }
            }
        }
        return trees;
    }

/*    public static void main(String[] args) {
        SimpleTreeNode node1 = new SimpleTreeNode("1");
        SimpleTreeNode node11 = new SimpleTreeNode("11", node1);
        SimpleTreeNode node12 = new SimpleTreeNode("12", node1);
        SimpleTreeNode node13 = new SimpleTreeNode("13", node1);
        SimpleTreeNode node2 = new SimpleTreeNode("2");
        SimpleTreeNode node21 = new SimpleTreeNode("21", node2);
        SimpleTreeNode node211 = new SimpleTreeNode("211", node21);
        List<TreeNode> list = new ArrayList<>();
        list.add(node2);
        list.add(node211);
        list.add(node1);
        list.add(node13);
        list.add(node12);
        list.add(node21);
        list.add(node11);
        Collection<TreeNode> merge = TreeUtil.merge(list);
        System.out.println(merge);
        Optional<List<String>> nullList = Optional.of(null);
        for(String s : nullList.get()) {
            System.out.println(s);
        }

    }*/
}
