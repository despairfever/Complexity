package ru.kfu.itis.ivanov.complexity.core;

import java.util.ArrayList;

/**
 * Created by Денис on 26.04.2015. Ave furby!
 */
public class Node {

    private ArrayList<Link> adjacent;
    private boolean isMarked;
    private int value;
    private int id;

    public Node() {
        adjacent = new ArrayList<Link>();
        isMarked = false;
        value = -1;
        id = 0;
    }

    public Node(int id) {
        adjacent = new ArrayList<Link>();
        isMarked = false;
        value = -1;
        this.id = id;
    }

    public void addAdjacent(Node node, int length) {
        Link link = new Link(this, node, length);
        adjacent.add(link);
    }

    @Override
    public String toString() {
        String line = this.getId()+": ";
        for (Link link : this.getAdjacent()) {
            line += link.getFinish().getId()+"("+link.getLength()+") ";
        }
        return line;
    }

    public ArrayList<Link> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(ArrayList<Link> adjacent) {
        this.adjacent = adjacent;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean isMarked) {
        this.isMarked = isMarked;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
