package ru.kfu.itis.ivanov.complexity;

import ru.kfu.itis.ivanov.complexity.core.Graph;

import java.io.IOException;

/**
 * Created by Денис on 26.04.2015. Ave furby!
 */
public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();
        String filepath = "graphs/3_graph.json";

        try {
            graph.readFromFile(filepath);
            graph.print();
            DijkstraSearchGraph dsg = new DijkstraSearchGraph(graph);
            long start = System.nanoTime();
            dsg.findDistance(0,2);
            long finish = System.nanoTime();
            long executionTime = finish - start;
            dsg.printResults();
            System.out.println(dsg.getPath(0,2));
            System.out.println("Computed in " + executionTime + "ns.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
