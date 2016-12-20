package questions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by deepanshu.saxena on 17/06/16.
 */
public class BST {

    Node root;
    Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(20);
        bst.insert(8);
        bst.insert(22);
        bst.insert(4);
        bst.insert(12);
        bst.insert(10);
        bst.insert(14);
        bst.nodeLevelOrderTraversal(bst.root);
        bst.findvalue(bst.root, 8);
//        bst.findMin(bst.root);
        bst.findMax(bst.root);
//        bst.delete(bst.root, 8);
//      bst.nodeLevelOrderTraversal(bst.root);
        bst.isBstorNot(bst.root);
        Node smallest = bst.kthSmallest(bst.root, 2, 0);
        System.out.println("kth smallest element :: " + smallest.getData());
        bst.pritnbetweenTwo(bst.root, 4, 14);
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.setLeft(null);
        newNode.setRight(null);
        if (root == null) {
            root = newNode;
            return;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (newNode.getData() < temp.getData()) {
                if (temp.getLeft() != null) {
                    queue.add(temp.getLeft());
                } else {
                    temp.setLeft(newNode);
                    queue.removeAll(queue);
                    return;
                }
            }
            if (newNode.getData() > temp.getData()) {
                if (temp.getRight() != null) {
                    queue.add(temp.getRight());
                } else {
                    temp.setRight(newNode);
                    queue.removeAll(queue);
                    return;
                }
            }
        }

        queue.removeAll(queue);
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.println("data: " + root.getData());
            inorder(root.getRight());
        }
    }

    private void nodeLevelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList();
        System.out.println("in traverseTree ");
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.println(" data :: " + temp.getData());
            if (temp.getLeft() != null) {
                q.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.add(temp.getRight());
            }
        }
        q.removeAll(q);
    }

    private void findvalue(Node root, int data) {
        boolean flag = false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp.getData() == data) {

                flag = true;
            }
            if (data < temp.getData()) {
                if (temp.getLeft() != null) {
                    q.add(temp.getLeft());
                }
            }
            if (data > temp.getData()) {
                if (temp.getRight() != null) {
                    q.add(temp.getRight());
                }
            }
        }
        if (flag) {
            System.out.println("value found ");
        } else {
            System.out.println("not found");
        }
        q.removeAll(q);
    }

    private void findMin(Node root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        System.out.println("min value :: " + root.getData());
    }

    private Node findMax(Node root) {
        while (root.getRight() != null) {
            root = root.getRight();
        }
        System.out.println("max value :: " + root.getData());
        return root;
    }

    private Node delete(Node root, int data) {
        Node temp;
        if (root == null) {
            System.out.println("element not there in tree ");
        } else if (data < root.getData()) {
            root.setLeft(delete(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(delete(root.getRight(), data));
        } else {
            //Element Found
            if (root.getLeft() != null && root.getRight() != null) {
                temp = findMax(root.getLeft());
                root.setData(temp.getData());
                root.setLeft(delete(root.getLeft(), root.getData()));
            } else {
                temp = root;
                if (root.getLeft() == null)
                    root = root.getRight();
                if (root.getRight() == null)
                    root = root.getLeft();
                temp = null;
            }
        }
        return root;
    }

    private void isBstorNot(Node root) {
        boolean flag = true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp.getLeft() != null && temp.getLeft().getData() > temp.getData()) {
                flag = false;
            }
            if (temp.getRight() != null && temp.getRight().getData() < temp.getData()) {
                flag = false;
            }
            if (temp.getLeft() != null && temp.getRight() != null) {
                if (temp.getLeft().getData() > temp.getData() || temp.getRight().getData() < temp.getData()) {
                    flag = false;
                }
            }
            System.out.println(" queue size :: " + q.size());
        }
        q.removeAll(q);
        if (flag) {
            System.out.println("bst ");
        } else {
            System.out.println("not bst");
        }


    }

    private void pritnbetweenTwo(Node root, int k1, int k2) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp.getData() >= k1 && temp.getData() <= k2) {
                System.out.println("bet data :: " + temp.getData());
            }
            if (temp.getLeft() != null && temp.getData() >= k1) {
                q.add(temp.getLeft());
            }
            if (temp.getRight() != null && temp.getData() <= k2) {
                q.add(temp.getRight());
            }
        }
        q.removeAll(q);
    }

    private Node kthSmallest(Node root, int k, int count) {
        if (root == null)
            return null;

        Node left = kthSmallest(root.getLeft(), k, count);
        if (left != null)
            return left;
        if (++count == k)
            return root;
        return kthSmallest(root.getRight(), k, count);

    }

}

