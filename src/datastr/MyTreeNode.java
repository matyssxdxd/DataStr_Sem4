package datastr;

import java.util.Objects;

public class MyTreeNode<T> {

    private T element;
    private MyTreeNode<T> left = null;
    private MyTreeNode<T> right = null;
    private MyTreeNode<T> parent = null;

    public MyTreeNode(T element) {
        setElement(element);
    }

    public T getElement() {
        return element;
    }

    public MyTreeNode<T> getLeft() {
        return left;
    }

    public MyTreeNode<T> getRight() {
        return right;
    }

    public MyTreeNode<T> getParent() {
        return parent;
    }

    public void setElement(T element) {
        this.element = Objects.requireNonNullElseGet(element, () -> (T) new Object());
    }

    public void setLeft(MyTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(MyTreeNode<T> right) {
        this.right = right;
    }

    public void setParent(MyTreeNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "MyTreeNode{" +
                "element=" + element +
                ", left=" + left +
                ", right=" + right +
                ", parent=" + parent +
                '}';
    }
}
