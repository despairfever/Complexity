package ru.kfu.itis.ivanov.complexity.testing;

import ru.kfu.itis.ivanov.complexity.core.Graph;
import ru.kfu.itis.ivanov.complexity.interfaces.IGraph;
import ru.kfu.itis.ivanov.complexity.interfaces.IGraphSearch;

import java.io.File;
import java.io.IOException;

/**
 * Created by Денис on 12.05.2015. Ave furby!
 */
public class Autotester {

    private int testID;
    private int batchID;
    private long executionTime;
    private int distance;
    private IGraph graph;
    private IGraphSearch igs;

    public Autotester(IGraphSearch igs, IGraph graph) {
        this.igs = igs;
        this.graph = graph;
    }

    public int getBatchID() {
        return batchID;
    }

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void test(int id, int start, int finish) throws IOException{

        String filePath = "test\\batch" + batchID + "\\test" + id + ".json";
        graph.readFromFile(filePath);
        igs.setGraph(graph);

        long timeStart = System.nanoTime();
        distance = igs.findDistance(start, finish);
        long timeFinish = System.nanoTime();
        executionTime = timeFinish - timeStart;

    }

    public String getPath(int start, int finish) {
        return igs.getPath(start, finish);
    }

    public void printResults() {
        igs.printResults();
    }

    public int getDistance() {
        return distance;
    }
}
