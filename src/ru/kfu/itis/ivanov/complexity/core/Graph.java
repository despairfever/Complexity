package ru.kfu.itis.ivanov.complexity.core;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.kfu.itis.ivanov.complexity.interfaces.IGraph;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Денис on 26.04.2015. Ave furby!
 */
public class Graph implements IGraph {

    protected ArrayList<Node> nodes;
    protected int size;
    protected boolean isDirected;

    public Graph() {
        nodes = new ArrayList<Node>(0);
        size = 0;
        isDirected = true;
    }

    public void readFromFile(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String data = "";
        String line = br.readLine();
        while (line != null) {
            data += line;
            line = br.readLine();
        }

        JSONObject obj = (new JSONObject(data)).getJSONObject("graph");
        size = obj.getInt("size");
        nodes = new ArrayList<Node>(size);
        for (int i=0; i<size; i++) {
            nodes.add(new Node(i));
        }
        isDirected = obj.getBoolean("isDirected");
        JSONArray arr = obj.getJSONArray("edges");

        int start, finish, length;
        JSONObject link;
        for (int i=0; i<arr.length(); i++) {
            link = arr.getJSONObject(i);
            start = link.getInt("start");
            finish = link.getInt("finish");
            length = link.getInt("length");

            nodes.get(start).addAdjacent(nodes.get(finish), length);
            if (!isDirected) nodes.get(finish).addAdjacent(nodes.get(start), length);
        }
    }

    public void print() {

        for (Node node : nodes) {
            System.out.println(node);
        }

    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public int getSize() {
        return size;
    }

    public boolean isDirected() {
        return isDirected;
    }
}