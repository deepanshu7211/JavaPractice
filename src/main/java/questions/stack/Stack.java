package questions.stack;

import java.util.Arrays;

/**
 * Created by deepanshu.saxena on 17/06/16.
 */
public class Stack {
    public static void main(String[] args) {
        int arr[] = new int[5];
        ArrayStack arrayStack = new ArrayStack(arr);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);

//        arrayStack.pop();
//        arrayStack.pop();
//        arrayStack.pop();
//        arrayStack.pop();
//        arrayStack.pop();

        StackUsingList stackUsingList = new StackUsingList();
        stackUsingList.push(1);
        stackUsingList.push(2);
        stackUsingList.push(3);
        stackUsingList.push(4);

        stackUsingList.traverse();

        stackUsingList.pop();
        stackUsingList.pop();

        stackUsingList.traverse();

        CheckParanthesis checkParanthesis = new CheckParanthesis();
        System.out.println(" valid paranthesis :: " + checkParanthesis.isParenthesisMatch("({)})"));

        EvaluateString evaluateString = new EvaluateString();
        System.out.println(evaluateString.evaluate("10 + 2 * 6"));
//        System.out.println(evaluateString.evaluate("100 * 2 + 12"));
//        System.out.println(evaluateString.evaluate("100 * ( 2 + 12 )"));
//        System.out.println(evaluateString.evaluate("100 * ( 2 + 12 ) / 14"));

    }
}


/* A Java program to evaluate a given expression where tokens are separated
   by space.
   Test Cases:
     "10 + 2 * 6"            ---> 22
     "100 * 2 + 12"          ---> 212
     "100 * ( 2 + 12 )"      ---> 1400
     "100 * ( 2 + 12 ) / 14" ---> 100
*/


class EvaluateString {
    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        System.out.println("tokens array :: " + Arrays.toString(tokens));

        // Stack for numbers: 'values'
        java.util.Stack<Integer> values = new java.util.Stack<Integer>();

        // Stack for Operators: 'ops'
        java.util.Stack<Character> ops = new java.util.Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9') {
//                System.out.println("token [i] :: " + tokens[i]);
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
            }

            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/') {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    System.out.println("has precedence :: " + hasPrecedence(tokens[i], ops.peek()));
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }


                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }


}

class CheckParanthesis {
    public boolean isParenthesisMatch(String str) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        char arr[] = str.toCharArray();
        char c;
        System.out.println("str " + Arrays.toString(arr));
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
//            System.out.println("c :: " + c);
            if (c == '(') {
                stack.push(c);
//                System.out.println("push1 " + c);
            } else if (c == '{') {
                stack.push(c);
//                System.out.println("push2 " + c);
            } else if (c == ')') {
                if (stack.empty())
                    return false;
                else {
                    if (stack.peek() == '(') {
//                        System.out.println("pop " + c);
                        stack.pop();
                    } else
                        return false;
                }
            } else if (c == '}') {
                if (stack.empty())
                    return false;
                else {
                    if (stack.peek() == '{') {
//                        System.out.println("pop2 " + c);
                        stack.pop();
                    } else
                        return false;
                }
            }
        }
//        System.out.println("stack " + stack);
        return stack.empty();
    }
}

class ArrayStack {
    private int arr[];
    private int top;
    private int size;

    public ArrayStack(int[] arr) {
        this.arr = arr;
        top = -1;
        size = arr.length - 1;

    }


    public void push(int data) {
        if (!isFull())
            arr[++top] = data;
        else {
            System.out.println("stack overflow");
            int arrnew[] = new int[2 * size];
            System.arraycopy(arr, 0, arrnew, 0, arr.length);
            arr = arrnew;
            arr[++top] = data;
            System.out.println("arr " + Arrays.toString(arr));
        }
    }

    public void pop() {
        if (!isEmpty())
            System.out.println("data " + arr[top--]);
        else
            System.out.println(" Stack Under Flow");
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size);
    }
}


class StackUsingList {
    private Node head = null;
    private Node tail = null;
    private int length;

    public void push(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.setNext(head);
            head = temp;
        }

    }

    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println("data :: " + temp.getData());
            temp = temp.getNext();
        }
    }

    public void pop() {
        System.out.println("pop data " + head.getData());
        Node temp = head.getNext();
        head = temp;
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


}
