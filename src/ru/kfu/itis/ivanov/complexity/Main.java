package ru.kfu.itis.ivanov.complexity;

import ru.kfu.itis.ivanov.complexity.core.Graph;
import ru.kfu.itis.ivanov.complexity.testing.Autotester;

import java.io.*;

/**
 * Created by Денис on 26.04.2015. Ave furby!
 */
public class Main {

    public static void main(String[] args) {

        try {
            int batchID = 10;
            int testNumber = 12;
            int start = 0;
            int[] finish = {39, 39, 39, 79, 79, 79, 159, 159, 159, 229, 229, 229};

            Autotester tester = new Autotester(new DijkstraSearchGraph(), new Graph());
            tester.setBatchID(batchID);

            PrintWriter pw = new PrintWriter("results\\dijkstra\\" + batchID + "result.txt", "UTF-8");

            for (int i=1; i<=testNumber; i++) {
                tester.test(i, start, finish[i-1]);
                System.out.println("Test ID: " + i);
                System.out.println("Result: " + (tester.getExecutionTime() / 1000));
                System.out.println("Distance: " + tester.getDistance());
                System.out.println("Path: " + tester.getPath(start, finish[i - 1]));
                System.out.println("==================");

                pw.println("Test ID: " + i);
                pw.println("Result: " + (tester.getExecutionTime() / 1000));
                pw.println("Distance: " + tester.getDistance());
                pw.println("Path: " + tester.getPath(start, finish[i - 1]));
                pw.println("==================");
            }

            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
