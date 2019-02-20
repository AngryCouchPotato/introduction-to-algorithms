package org.kaa.datastructure.trees;

import org.kaa.datastructure.trees.BinaryTree.Node;

public class Trees {
  static <T> void inOrderTreeWalk(BinaryTree<T> tree){
    if(tree != null){
      inOrderTreeWalk(tree.getRoot());
    }
  }

  private static <T> void inOrderTreeWalk(Node node){
    if(node != null){
      inOrderTreeWalk(node.left);
      System.out.println(node.key);
      inOrderTreeWalk(node.right);
    }
  }
}

