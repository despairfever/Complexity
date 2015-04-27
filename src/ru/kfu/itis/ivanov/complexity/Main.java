package ru.kfu.itis.ivanov.complexity;

import java.io.IOException;

/**
 * Created by Денис on 26.04.2015. Ave furby!
 */
public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();
        try {
            graph.readFromFile("graphs/secondgraph.json");
            graph.print();
            DijkstraSearchGraph dsg = new DijkstraSearchGraph(graph);
            dsg.findDistance(0,4);
            dsg.printResults();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
