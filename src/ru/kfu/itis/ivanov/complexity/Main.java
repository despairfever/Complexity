package ru.kfu.itis.ivanov.complexity;

import ru.kfu.itis.ivanov.complexity.core.Graph;
import ru.kfu.itis.ivanov.complexity.testing.Autotester;

import java.io.IOException;

/**
 * Created by Денис on 26.04.2015. Ave furby!
 */
public class Main {

    public static void main(String[] args) {

        try {
            int testNumber = 12;
            int start = 0;
            int[] finish = {24, 24, 24, 79, 79, 79, 139, 139, 139, 199, 199, 199};
            Autotester tester = new Autotester(new DijkstraSearchGraph(), new Graph());

            for (int i=1; i<=testNumber; i++) {
                tester.test(i, start, finish[i]);
                System.out.print("Test ID: " + i);
                System.out.print("Result: " + tester.getExecutionTime());
                System.out.print("Path: " + tester.getPath(start, finish[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
