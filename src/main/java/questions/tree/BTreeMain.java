package questions.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by deepanshu.saxena on 17/06/16.
 */
public class BTreeMain {
    Node root;
    Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        BTreeMain bTreeMain = new BTreeMain();
        bTreeMain.insert(1);
        bTreeMain.insert(2);
        bTreeMain.insert(3);
        bTreeMain.insert(4);
        bTreeMain.insert(5);
        bTreeMain.insert(6);
        bTreeMain.insert(7);
        bTreeMain.levelOrderTraversal(bTreeMain.root);
//       System.out.println(" roo :: " + bTreeMain.root.getData());
//       bTreeMain.preOrder(bTreeMain.root);
//        bTreeMain.search(15);
//       bTreeMain.preOrderNonRecursive();
//       bTreeMain.heightOfTree();
//       bTreeMain.deepestNode();
//        bTreeMain.maxSumLevel();

        //For Root to leaf paths
//       int[] path=new int[256];
//       bTreeMain.printRootToLeaf(path,bTreeMain.root, 0);

//        bTreeMain.mirror();
//        bTreeMain.levelOrderTraversal(bTreeMain.root);

    }

    private void insert(int data) {

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

            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            } else {
                temp.setLeft(newNode);
                queue.removeAll(queue);

                return;
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            } else {

                temp.setRight(newNode);
                queue.removeAll(queue);

            }
        }
        queue.removeAll(queue);
    }


    private void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList();
        System.out.println("in traverseTree ");
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.println("data :: " + temp.getData());
            if (temp.getLeft() != null) {
                q.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.add(temp.getRight());
            }
        }
        q.removeAll(q);
    }

    private void search(int data) {
        boolean flag = false;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp.getData() == data) {
                System.out.println("element found " + temp.getData());
                flag = true;
                break;
            }
            if (temp.getLeft() != null) {
                q.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.add(temp.getRight());
            }

        }
        q.removeAll(q);

        if (!flag)
            System.out.println("element not found");
    }

    private void preOrder(Node currentNode) {
        if (currentNode != null) {
            System.out.println(currentNode.getData());
            preOrder(currentNode.getLeft());
            preOrder(currentNode.getRight());
        }
    }

    private void inOrder(Node currentNode) {
        if (currentNode != null) {
            inOrder(currentNode.getLeft());
            System.out.println(currentNode.getData());
            inOrder(currentNode.getRight());

        }
    }

    private void postorder(Node currentNode) {
        if (currentNode != null) {
            postorder(currentNode.getLeft());
            postorder(currentNode.getRight());
            System.out.println(currentNode.getData());
        }
    }

    private void preOrderNonRecursive() {
        java.util.Stack<Node> s = new java.util.Stack<>();
        while (true) {
            while (root != null) {
                System.out.println("preOrderNonRecursive data :: " + root.getData());
                s.push(root);
                root = root.getLeft();
            }
            if (s.isEmpty())
                break;
            root = s.pop();
            root = root.getRight();
        }
    }

    private void maxElement() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp.getData() > max) {
                max = temp.getData();
            }
            if (temp.getLeft() != null) {
                q.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.add(temp.getRight());
            }
        }
        q.removeAll(q);
        System.out.println("max :: " + max);
    }

    private void size() {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            count++;

            if (temp.getLeft() != null) {
                q.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.add(temp.getRight());
            }
        }
        q.removeAll(q);
        System.out.println("size :: " + count);
    }

    private void reverse() {
        java.util.Stack<Node> s = new java.util.Stack<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            s.push(temp);

            if (temp.getLeft() != null) {
                q.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.add(temp.getRight());
            }
        }
        q.removeAll(q);
        while (!s.isEmpty()) {
            System.out.println("reverse " + s.pop().getData());
        }
    }

    private void heightOfTree() {
        Queue<Node> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    level++;
                }

            } else {
                if (temp.getLeft() != null) {
                    q.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    q.add(temp.getRight());
                }
            }
        }
        q.removeAll(q);
        System.out.println("height " + level);
    }

    private void deepestNode() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.remove();
            if (temp.getLeft() != null) {
                q.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                q.add(temp.getRight());
            }
        }
        q.removeAll(q);
        System.out.println(" deepest element :: " + temp);
    }

    private void maxSumLevel() {
        Queue<Node> q = new LinkedList<>();
        int currentsum = 0, maxsum = 0, level = 0, maxlevel = 0;
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (currentsum > maxsum) {
                    maxsum = currentsum;
                    maxlevel = level;
                }
                currentsum = 0;
                if (!q.isEmpty())
                    q.add(null);
                level++;
            } else {
                currentsum = currentsum + temp.getData();
                if (temp.getLeft() != null)
                    q.add(temp.getLeft());
                if (temp.getRight() != null)
                    q.add(temp.getRight());
            }
        }
        q.removeAll(q);
        System.out.println("max level : " + maxlevel + " max level sum :: " + maxsum);
    }

    private void printRootToLeaf(int arr[], Node node, int length) {
//         System.out.println("node :: " + node.getData());
        if (node == null) {
            System.out.println("node is null");
            return;
        }
        arr[length] = node.getData();
        length++;

        if (node.getLeft() == null && node.getRight() == null) {
//             System.out.println(Arrays.toString(arr));
            printarray(arr, length);
        } else {
            printRootToLeaf(arr, node.getLeft(), length);
            printRootToLeaf(arr, node.getRight(), length);
        }
    }

    private void printarray(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " - ");
        }
    }

    private void mirror() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp.getLeft() != null)
                q.add(temp.getLeft());
            if (temp.getRight() != null)
                q.add(temp.getRight());

            if (temp.getLeft() != null && temp.getRight() != null) {
                Node t = temp.getLeft();
                temp.setLeft(temp.getRight());
                temp.setRight(t);
            }
            if (temp.getLeft() != null && temp.getRight() == null) {
                Node t = temp.getLeft();
                temp.setLeft(temp.getRight());
                temp.setRight(t);
            }
            if (temp.getRight() != null && temp.getLeft() == null) {
                Node t = temp.getLeft();
                temp.setLeft(temp.getRight());
                temp.setRight(t);
            }

        }
        q.removeAll(q);
    }
}

