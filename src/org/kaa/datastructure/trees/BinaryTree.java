package org.kaa.datastructure.trees;

public class BinaryTree<T> {

  private Node<T> root;

  public BinaryTree() {
  }

  public BinaryTree(Node<T> root) {
    this.root = root;
  }

  public Node<T> getRoot() {
    return root;
  }

  public void setRoot(Node<T> root) {
    this.root = root;
  }

  public void insert(BinaryTree<T> tree, Node<T> node){
    Node<T> current = tree.root;
    Node<T> parent = null ;
    while(current != null){
      parent = current;
      if(node.key > current.key){
        current = current.right;
      } else {
        current = current.left;
      }
    }
    node.parent = parent;
    if(current == null){
      tree.root = node;
    } else if(node.key > parent.key){
      parent.right = node;
    } else {
      parent.left = node;
    }
  }

  public void delete(BinaryTree<T> tree, Node<T> node){
    if(node.left == null){
      transplant(tree, node, node.right);
    } else if(node.right == null) {
      transplant(tree, node, node.left);
    } else {
      Node<T> min = minimum(node.right);
      if(min.parent != node){
        transplant(tree, min, min.right);
        min.right = node.right;
        min.right.parent = min;
      }
      transplant(tree, node, min);
      min.left = node.left;
      min.left.parent = min;
    }
  }

  public void transplant(BinaryTree<T> tree, Node<T> deleted, Node<T> added){
    if(deleted.parent == null){
      tree.root = added;
    } else if(deleted == deleted.parent.left){
      deleted.parent.left = added;
    } else {
      deleted.parent.right = added;
    }
    if(added != null){
      added.parent = deleted.parent;
    }
  }

  Node<T> search(int key){
    return search(this.root, key);
  }

  private Node<T> search(Node<T> node, int key){
    if(node == null || node.key == key) {
      return node;
    }
    if(node.key > key) {
      return search(node.left, key);
    } else {
      return search(node.right, key);
    }
  }

  Node<T> searchIterative(int key){
    return searchIterative(this.root, key);
  }

  private Node<T> searchIterative(Node<T> node, int key) {
    while(node != null || node.key != key) {
      if(node.key > key){
        node = node.left;
      } else {
        node = node.right;
      }
    }
    return node;
  }

  Node<T> minimum(){
    return minimum(this.getRoot());
  }

  private Node<T> minimum(Node<T> node){
    while(node.left != null){
      node = node.left;
    }
    return node;
  }

  Node<T> maximum(){
    return maximum(this.getRoot());
  }

  private Node<T> maximum(Node<T> node){
    while(node.right != null){
      node = node.right;
    }
    return node;
  }

  // Exercise 12.2.2
  public Node<T> maximumRecursive(){
    return maximumRecursive(this.getRoot());
  }

  private Node<T> maximumRecursive(Node<T> node) {
    if(node.right != null){
      return maximumRecursive(node.right);
    }
    return node;
  }

  // Exercise 12.2.2
  public Node<T> minimumRecursive(){
    return minimumRecursive(this.getRoot());
  }

  private Node<T> minimumRecursive(Node<T> node) {
    if(node.left != null){
      return minimumRecursive(node.left);
    }
    return node;
  }

  Node<T> successor(Node<T> node){
    if(node.right != null){
      return minimum(node.right);
    }
    Node<T> parent = node.parent;
    while(parent != null && node == parent.right) {
      node = parent;
      parent = node.parent;
    }
    return parent;
  }

  Node<T> predecessor(Node<T> node){
    if(node.left != null){
      return maximum(node.left);
    }
    Node<T> parent = node.parent;
    while(parent != null && node == parent.left) {// todo check it
      node = parent;
      parent = node.parent;
    }
    return parent;
  }

  class Node<T>{
    Node<T> parent;
    Node<T> left;
    Node<T> right;
    T value;
    int key;

    public Node(T value, int key) {
      this.value = value;
      this.key = key;
    }

    public Node(Node<T> parent, Node<T> left, Node<T> right, T value, int key) {
      this.parent = parent;
      this.left = left;
      this.right = right;
      this.value = value;
      this.key = key;
    }

  }
}

