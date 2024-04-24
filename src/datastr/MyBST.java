package datastr;

public class MyBST<T> {

    private MyTreeNode<T> root = null;
    private int counter = 0;

    public boolean isEmpty() {
        return (counter == 0);
    }

    public int howManyElements() {
        return counter;
    }

    public void add(T element) throws Exception {
        if (element == null) throw new Exception("Element is null");

        if (isEmpty()) {
            root = new MyTreeNode<>(element);
            counter++;
        } else {
            insertHelperRecursive(root, element);
        }

    }

    private void insertHelperRecursive(MyTreeNode<T> node, T element) {
        if (((Comparable)node.getElement()).compareTo(element) == 1) {
            if (node.getLeft() == null) {
                node.setLeft(new MyTreeNode<>(element));
                node.getLeft().setParent(node);
                counter++;
            } else {
                insertHelperRecursive(node.getLeft(), element);
            }
        } else if (((Comparable)node.getElement()).compareTo(element) == -1) {
            if (node.getRight() == null) {
                node.setRight(new MyTreeNode<>(element));
                node.getRight().setParent(node);
                counter++;
            } else {
                insertHelperRecursive(node.getRight(), element);
            }
        } else {
            System.out.println("Element " + element + " is already in the tree");
        }
    }

    public void print() throws Exception {
        if (isEmpty()) throw new Exception("Tree is empty");

        printHelperRecursivePreOrder(root);
    }

    private void printHelperRecursivePreOrder(MyTreeNode<T> node) {
        System.out.println("P: " + node.getElement());

        if (node.getLeft() != null) {
            System.out.println(" -> LC: " + node.getLeft().getElement()
                    + " [ " + node.getElement() + " ] ");
            printHelperRecursivePreOrder(node.getLeft());
        }

        if (node.getRight() != null) {
            System.out.println(" -> RC: " + node.getRight().getElement()
                    + " [ " + node.getElement() + " ] ");
            printHelperRecursivePreOrder(node.getRight());
        }
    }

    public boolean search(T element) throws Exception {
        if (isEmpty()) throw new Exception("Tree is empty");

        return searchHelperRecursive(root, element);
    }

    private boolean searchHelperRecursive(MyTreeNode<T> node, T element) {
        if (node.getElement().equals(element)) return true;

        if (((Comparable)node.getElement()).compareTo(element) == 1) {
            if (node.getLeft() != null) return searchHelperRecursive(node.getLeft(), element);
        } else if (((Comparable)node.getElement()).compareTo(element) == -1) {
            if (node.getRight() != null) return searchHelperRecursive(node.getRight(), element);
        }

        return false;
    }

    public void delete(T element) throws Exception {
        if (isEmpty()) throw new Exception("Tree is empty");

        deleteHelperRecursive(root, element);
    }

    private void deleteHelperRecursive(MyTreeNode<T> node, T element) throws Exception {
        if (!search(element)) throw new Exception("Element " + element + " is not in the tree");

        if (node.getElement().equals(element)) {
            if (node.getLeft() == null && node.getRight() == null) {
                MyTreeNode<T> parent = node.getParent();

                if (parent.getLeft().equals(node)) {
                    parent.setLeft(null);
                } else if (parent.getRight().equals(node)) {
                    parent.setRight(null);
                }
            }
        }
    }
}
