package spr.auto_wire;

/**
 * Created by deepanshu.saxena on 29/02/16.
 */
public class A {
    private B b;
    private B b1;

    A() {
        System.out.println("a is created");
    }

    public A(B b, B b1) {
        this.b = b;
        this.b1 = b1;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public B getB1() {
        return b1;
    }

    public void setB1(B b1) {
        this.b1 = b1;
    }


    void print() {
        System.out.println("hello a");
    }

    void display() {
        print();
        b.print();
        b1.print();
    }
}
