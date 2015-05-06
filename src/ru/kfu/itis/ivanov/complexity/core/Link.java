package ru.kfu.itis.ivanov.complexity.core;

/**
 * Created by Денис on 26.04.2015. Ave furby!
 */
public class Link {

    private Node start;
    private Node finish;
    private int length;

    public Link(Node start, Node finish, int length) {
        this.start = start;
        this.finish = finish;
        this.length = length;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getFinish() {
        return finish;
    }

    public void setFinish(Node finish) {
        this.finish = finish;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
