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

  public void insert(Node<T> node){
    Node<T> current = root;
    Node<T> parent = null ;
    while(current != null){
      parent = current;
      if(node.getKey() > current.getKey()){
        current = current.getRight();
      } else {
        current = current.getLeft();
      }
    }
    node.setParent(parent);
    if(current == null){
      root = node;
    } else if(node.getKey() > parent.getKey()){
      parent.setRight(node);
    } else {
      parent.setLeft(node);
    }
  }

  Node<T> search(int key){
    return search(this.root, key);
  }

  private Node<T> search(Node<T> node, int key){
    if(node == null || node.getKey() == key) {
      return node;
    }
    if(node.getKey() > key) {
      return search(node.getLeft(), key);
    } else {
      return search(node.getRight(), key);
    }
  }

  Node<T> searchIterative(int key){
    return searchIterative(this.root, key);
  }

  private Node<T> searchIterative(Node<T> node, int key) {
    while(node != null || node.getKey() != key) {
      if(node.getKey() > key){
        node = node.getLeft();
      } else {
        node = node.getRight();
      }
    }
    return node;
  }

  Node<T> minimum(){
    return minimum(this.getRoot());
  }

  private Node<T> minimum(Node<T> node){
    while(node.getLeft() != null){
      node = node.getLeft();
    }
    return node;
  }

  Node<T> maximum(){
    return maximum(this.getRoot());
  }

  private Node<T> maximum(Node<T> node){
    while(node.getRight() != null){
      node = node.getRight();
    }
    return node;
  }

  // Exercise 12.2.2
  public Node<T> maximumRecursive(){
    return maximumRecursive(this.getRoot());
  }

  private Node<T> maximumRecursive(Node<T> node) {
    if(node.getRight() != null){
      return maximumRecursive(node.getRight());
    }
    return node;
  }

  // Exercise 12.2.2
  public Node<T> minimumRecursive(){
    return minimumRecursive(this.getRoot());
  }

  private Node<T> minimumRecursive(Node<T> node) {
    if(node.getLeft() != null){
      return minimumRecursive(node.getLeft());
    }
    return node;
  }

  Node<T> successor(Node<T> node){
    if(node.getRight() != null){
      return minimum(node.getRight());
    }
    Node<T> parent = node.getParent();
    while(parent != null && node == parent.getRight()) {
      node = parent;
      parent = node.getParent();
    }
    return parent;
  }

  Node<T> predecessor(Node<T> node){
    if(node.getLeft() != null){
      return maximum(node.getLeft());
    }
    Node<T> parent = node.getParent();
    while(parent != null && node == parent.getLeft()) {// todo check it
      node = parent;
      parent = node.getParent();
    }
    return parent;
  }

  class Node<T>{
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;
    private T value;
    private int key;

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

    public Node<T> getParent() {
      return parent;
    }

    public void setParent(Node<T> parent) {
      this.parent = parent;
    }

    public Node<T> getLeft() {
      return left;
    }

    public void setLeft(Node<T> left) {
      this.left = left;
    }

    public Node<T> getRight() {
      return right;
    }

    public void setRight(Node<T> right) {
      this.right = right;
    }

    public T getValue() {
      return value;
    }

    public void setValue(T value) {
      this.value = value;
    }

    public int getKey() {
      return key;
    }

    public void setKey(int key) {
      this.key = key;
    }
  }
}

